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
        return new CustomerString().toString();
    }

    class CustomerString {
        StringBuffer buffer = new StringBuffer();
        String currentAccountType = null;

        public String toString() {
            buffer.append("Summary for customer: " + name + "\n");
            for (Account account : getSortedAccounts()) {
                headingBreakIfTypeChanged(account);
                appendAccount(account);
                currentAccountType = account.getType();
            }
            return buffer.toString();
        }

        private void headingBreakIfTypeChanged(Account account) {
            if (account.getType().equals(currentAccountType))
                return;
            buffer.append("\n\n******************  " + account.getType() + "  *******\n");
        }

        private void appendAccount(Account account) {
            buffer.append("\tAccount:" + account.getNumber() + "\n");
            for (Transaction transaction : account.getTransactions()) {
                appendTransaction(transaction);
            }
        }

        private void appendTransaction(Transaction transaction) {
            String suffix = "\t\t";
            if (transaction.getType().equals("CREDIT"))
                suffix = "-";
            //reduced duplication even within the one method.
            buffer.append ("\t\tTransaction:\t\t" + suffix + transaction.getAmount() + "\n");
        }

        private List<Account> getSortedAccounts() {
            List<Account> sortedAccounts = new ArrayList<>();
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
}
