package ca.attractors.accounting;



import java.math.BigDecimal;
import java.util.List;

public class Account {

    public List<Transaction> getTransactions() {
        return transactions;
    }

    List<Transaction> transactions;
    public double getBalance() {
        double balance = 0.0;
        for (Transaction transaction: transactions)
            balance += transaction.getBalance();
        return balance;
    }

}
