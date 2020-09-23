package ca.attractors.accounting;
import java.math.BigDecimal;
import java.util.List;

public class Account {
    List<Transaction> transactions;
    private String type;
    private String number;
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}
