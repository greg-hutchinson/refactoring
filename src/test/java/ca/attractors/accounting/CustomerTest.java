package ca.attractors.accounting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testToString() {
        Customer customer = new Customer();
        Transaction transaction1 = new Transaction("CREDIT", 200.00);
        Transaction transaction2 = new Transaction("DEBIT", 100.00);
        Transaction transaction3 = new Transaction("DEBIT", 500.00);
        Account account1 = new Account("expense", "12345");
        account1.addTransaction(transaction1);

        Account account2 = new Account("expense", "12346");
        account2.addTransaction(transaction1);
        account2.addTransaction(transaction2);

        Account account3 = new Account("asset", "98765");
        account3.addTransaction(transaction1);
        account3.addTransaction(transaction2);
        account3.addTransaction(transaction3);

        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        System.out.println(customer.toString());
    }
}