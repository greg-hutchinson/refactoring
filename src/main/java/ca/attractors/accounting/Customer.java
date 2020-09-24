package ca.attractors.accounting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Customer {
    private List<Account> accounts = new ArrayList<>();;
    private String name = "Important Customer";
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
    public void addAccount(Account account) {
        accounts.add(account);
    }
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Summary for customer: " + name + "\n");
        String currentAccountType = null;
        for (Account account: getSortedAccounts()) {
            currentAccountType = possibleHeadingBreak(buffer, currentAccountType, account);
            appendAccountTo(account, buffer);
        }
        return buffer.toString();
    }

    private String possibleHeadingBreak(StringBuffer buffer, String currentAccountType, Account account) {
        if (!account.getType().equals(currentAccountType)) {
            currentAccountType = account.getType();
            buffer.append("\n\n******************  " + currentAccountType + "  *******\n");
        }
        return currentAccountType;
    }

    private void appendAccountTo(Account account, StringBuffer buffer) {
        buffer.append("\tAccount:" + account.getNumber() + "\n");
        for (Transaction transaction: account.getTransactions()) {
            appendTransactionTo(transaction, buffer);
        }
    }

    private void appendTransactionTo(Transaction transaction, StringBuffer buffer) {
        if (transaction.getType().equals("CREDIT")) {
            buffer.append("\t\tTransaction:\t\t-" + transaction.getAmount() + "\n");
        }
        else {
            buffer.append("\t\tTransaction:\t\t\t\t" + transaction.getAmount() + "\n");
        }
    }

    private List<Account> getSortedAccounts() {
        List <Account> sortedAccounts = new ArrayList<>();
        sortedAccounts.addAll(accounts);
        sortedAccounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getType().compareTo(o2.getType());
            }
        });
        return sortedAccounts;
    }
}
