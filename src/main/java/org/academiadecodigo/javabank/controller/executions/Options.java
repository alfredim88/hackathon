package org.academiadecodigo.javabank.controller.executions;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.language.English;

public enum Options {
    LOGIN(English.LOGIN),
    REGISTER(English.REGISTER),
    QUIT(English.MENU_QUIT);

    private Controller handler;
    private String description;

    Options(String description) {
        this.description = description;
    }

    public static Options checkOption(int optionIndex){
        return values()[optionIndex];
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
