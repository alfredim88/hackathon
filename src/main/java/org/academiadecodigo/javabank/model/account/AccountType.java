package org.academiadecodigo.javabank.model.account;

import org.academiadecodigo.javabank.language.English;

/**
 * The possible {@link Account} types
 */
public enum AccountType {

    /**
     * @see CheckingAccount
     */
    CHECKING(English.CHECKING),

    /**
     * @see SavingsAccount
     */
    SAVINGS(English.SAVINGS);

    private String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
