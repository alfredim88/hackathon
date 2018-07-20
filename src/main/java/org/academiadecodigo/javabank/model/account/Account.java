package org.academiadecodigo.javabank.model.account;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.customer.Customer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * A generic account model entity to be used as a base for concrete types of accounts
 */
@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "account_type",
        discriminatorType = DiscriminatorType.STRING
)
public abstract class Account extends AbstractModel {

    @ManyToOne
    private Customer customer;

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public abstract AccountType getAccountType();

    public void credit(double amount) {
        if (canCredit(amount)) {
            balance += amount;
        }
    }

    public void debit(double amount) {
        if (canDebit(amount)) {
            balance -= amount;
        }
    }

    public boolean canCredit(double amount) {
        return amount > 0;
    }

    public boolean canDebit(double amount) {
        return amount > 0 && amount <= balance;
    }

    public boolean canWithdraw() {
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
