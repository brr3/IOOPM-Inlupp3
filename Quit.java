package org.ioopm.calculator.ast;

public class Quit extends Command {
    private static final Quit theInstance = new Quit();

    private Quit() {}

    public static Quit instance() {
        return theInstance;
    }

    public String getName() {
        return "quit";
    }

    @Override
    public boolean isCommand() {
        return true;
    }

}
