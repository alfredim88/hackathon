package org.academiadecodigo.javabank.model.customer;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.account.Account;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;

/**
 * The customer model entity
 */
@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {

    private String username;

    private String email;

    private String password;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "customer",
            fetch = FetchType.EAGER
    )
    private Set<Account> accounts;

    public Customer() {
        accounts = new HashSet<>();
    }

    public boolean checkPassword(String pass){
        return pass.equals(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public Set<Integer> getAccountsIDs(){

        Set<Integer> accountsIDs = new HashSet<>();

        System.out.println(getAccounts());
        for (Account account: getAccounts()) {
            accountsIDs.add(account.getId());
        }
        return accountsIDs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
