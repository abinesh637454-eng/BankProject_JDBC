package Project_01.Bank_Project;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankController {

    private List<BankAccount> accounts = new ArrayList<>();

    public BankController() {
        accounts.add(new BankAccount(1, "Abinesh", 10000));
        accounts.add(new BankAccount(2, "Rahul", 15000));
    }

    // GET - Get all accounts
    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return accounts;
    }

    // GET - Get one account
    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable int id) {

        for (BankAccount account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }

        return null;
    }
    // POST - Add new account
    @PostMapping
    public String addAccount(@RequestBody BankAccount account) {
        accounts.add(account);
        return "Account added successfully";
    }
    // PUT - Update account
    @PutMapping("/{id}")
    public String updateAccount(
            @PathVariable int id,
            @RequestBody BankAccount updatedAccount) {

        for (BankAccount account : accounts) {

            if (account.getId() == id) {

                account.setName(updatedAccount.getName());
                account.setBalance(updatedAccount.getBalance());

                return "Account updated successfully";
            }
        }

        return "Account not found";
    }
    // DELETE - Delete account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable int id) {

        for (BankAccount account : accounts) {

            if (account.getId() == id) {
                accounts.remove(account);
                return "Account deleted successfully";
            }
        }

        return "Account not found";
    }
}
