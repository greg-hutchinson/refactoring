package ca.attractors.accounting;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Customer {
    private List<Account> accounts;
    private String name = "";
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
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Summary for customer: " + name + "\n");
        buffer.append("*********************************\n");
        List <Account> sortedAccounts = new ArrayList<>();
        sortedAccounts.addAll(accounts);
        sortedAccounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getType().compareTo(o2.getType());
            }
        });
        String oldType = null;
        for (Account account: sortedAccounts) {
            if (oldType == null) {
                oldType = account.getType();
            }
            if (!account.getType().equals(oldType)) {
                buffer.append("******************\n\n\n");
                oldType = account.getType();
            }
            buffer.append("\tAccount:" + account.getNumber());
            for (Transaction transaction: account.getTransactions()) {
                if (transaction.getType().equals("CREDIT")) {
                    buffer.append("\t\tTransaction:\t\t-" + transaction.getAmount());
                }
                else {
                    buffer.append("\t\tTransaction:\t\t\t\t" + transaction.getAmount());
                }
            }
        }
        return buffer.toString();
    }

}
