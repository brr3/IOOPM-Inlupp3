package org.ioopm.calculator.ast;

public class Vars extends Command {
    private static final Vars theInstance = new Vars();
    private Vars() {}
    public static Vars instance() {
        return theInstance;
    }

    public String getName() {
        return "vars";
    }

    @Override
    public boolean isCommand() {
        return true;
    }
}
