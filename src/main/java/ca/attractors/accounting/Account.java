package ca.attractors.accounting;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    List<Transaction> transactions = new ArrayList<>();
    private String type;
    private String number;

    public Account(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

}
