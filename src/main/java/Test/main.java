package Test;

import config.Config;
import entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repon.AccountRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class main {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
    static AccountRepository accountRepository = (AccountRepository) applicationContext.getBean("accountRepository");

    public static void main(String[] args) {
        createNewAccount();
//        listAllCustomers();
//        findByName("hoang");
//        findByNames("hoang","hoang@gmaiwwl.com");
//        findAccountById(1);
    }

    private static void createNewAccount() {
//        Account accc1 = new Account();
//        accc1.setName("hoang");
//        accc1.setBalance(783);
//        accc1.setEmail("hoang@gmaiwwl.com");
//        Account ac = accountRepository.save(accc1);
        Account accc3 = new Account();
        accc3.setName("huy4");
        accc3.setBalance(78314);
        accc3.setEmail("hoang14@gmaiwwl.com");
        Account ac3 = accountRepository.save(accc3);

        if (ac3 != null) {
            System.out.println("Một tài khoản mới đã được lưu thành công, accountId = " + ac3.getId());
        }
    }
    private static void listAllCustomers() {
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        accounts.forEach(account ->
                System.out.println("ID: " + account.getId() + ", Name: " + account.getName() + ", Email: " + account.getEmail()  + ", Balance: " + account.getBalance()));
    }
    private static void findByName(String names) {
        List<Account> accounts = accountRepository.findByName(names);
        if (!accounts.isEmpty()) {
            System.out.println("Customers found by name: " + names);
            accounts.forEach(account ->
                    System.out.println("ID: " + account.getId() + ", Name: " + account.getName() + ", Email: " + account.getEmail() +", Balance: " + account.getBalance()));
        } else {
            System.out.println("No customers found by name: " + names);
        }

    }
    private static void findByNames(String names,String email) {
        List<Account> accounts = accountRepository.findByNameAndEmail(names,email);
        if (!accounts.isEmpty()) {
            System.out.println("Customers found by name: " + names);
            System.out.println("Customers found by mail: " + email);
            accounts.forEach(account ->
                    System.out.println("ID: " + account.getId() + ", Name: " + account.getName() + ", Email: " + account.getEmail() +", Balance: " + account.getBalance()));
        } else {
            System.out.println("No customers found by name: " + names);
        }

}
    private static void findAccountById(int id) {
        Optional<Account> accountOpt = accountRepository.findById(id);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            System.out.println("ID: " + account.getId() + ", Name: " + account.getName() + ", Email: " + account.getEmail() + ", Balance: " + account.getBalance());
        } else {
            System.out.println("No account found with ID: " + id);
        }
    }
}
