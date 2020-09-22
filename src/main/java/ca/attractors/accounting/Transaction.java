package ca.attractors.accounting;

public class Transaction {
    private String type;
    private double amount;

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        double balance = 0.0;
        if (type.equals("CREDIT"))
            return -amount;
        return amount;
    }

}
