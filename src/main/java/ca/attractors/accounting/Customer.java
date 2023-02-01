package ca.attractors.accounting;

import java.util.List;

public class Customer {
    private List<Account> accounts;
    public double getBalance() {
        double balance = 0.0;
        for (Account account: accounts) {
            //Refactor - Extract Method - Suggestion is ugly.
            //Refactor - Introduce temp variable and try again.
            //Refactor - then move instance method

            for (Transaction transaction: account.getTransactions()) {
                if (transaction.getType().equals("CREDIT"))
                    balance -= transaction.getAmount();
                else
                    balance += transaction.getAmount();
            }
        }
        return balance;
    }

}
