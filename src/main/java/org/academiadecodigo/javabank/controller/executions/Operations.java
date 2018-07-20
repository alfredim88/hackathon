package org.academiadecodigo.javabank.controller.executions;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.language.English;

public enum Operations {
    OPEN_ACCOUNT(English.OPEN_ACCOUNT),
    ACCOUNTS_IDS(English.LIST_ACCOUNTS),
    CHECK_BALANCE(English.CHECK_BALANCE),
    DEPOSIT(English.DEPOSIT),
    WITHDRAW(English.WITHDRAW),
    TRANSFER(English.TRANSFER),
    LOG_OFF(English.LOG_OFF);

    private Controller handler;
    private String description;

    Operations(String description) {
        this.description = description;
    }

    public static Operations checkOperation(int operationIndex){
        return values()[operationIndex];
    }

    public Controller getHandler() {
        return handler;
    }

    public String getDescription() {
        return description;
    }

    public void setHandler(Controller handler) {
        this.handler = handler;
    }
}
