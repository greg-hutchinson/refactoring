package ca.attractors.accounting;

import java.math.BigDecimal;
import java.util.List;

public class Customer {
    private List<Account> accounts;
    public double getBalance() {
        double balance = 0.0;
        for (Account account: accounts) {
            for (Transaction transaction: account.getTransactions()) {
                if (transaction.getType().equals("CREDIT"))
                    balance -= transaction.getAmount();
                else
                    balance += transaction.getAmount();
            }
        }
        return balance;
    }

    public double getBalance2() {
        double balance = 0.0;
        for (Account account: accounts) {
            balance += getBalanceFor(account);
        }
        return balance;
    }

    public double getBalanceFor(Account account) {
        double balance = 0.0;
        for (Transaction transaction: account.getTransactions()) {
            if (transaction.getType().equals("CREDIT"))
                balance -= transaction.getAmount();
            else
                balance += transaction.getAmount();
        }
        return balance;
    }
    public double getBalance3() {
        double balance = 0.0;
        for (Account account: accounts) {
            balance += account.getBalance();
        }
        return balance;
    }

}
