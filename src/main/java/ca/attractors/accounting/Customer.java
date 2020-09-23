package ca.attractors.accounting;
import java.math.BigDecimal;
import java.util.List;
public class Customer {
    private List<Account> accounts;
    public double getBalance() {
        double balance = 0.0;
        for (Account account: accounts) {
            /* Consider Loop bodies */
            for (Transaction transaction: account.getTransactions()) {
                /* Consider Loop bodies */
                if (transaction.getType().equals("CREDIT"))
                    balance -= transaction.getAmount();
                else
                    balance += transaction.getAmount();
            }
        }
        return balance;
    }
}
