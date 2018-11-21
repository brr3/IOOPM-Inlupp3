package org.ioopm.calculator.ast;

public class Vars extends Command {
    private static final Vars theInstance = new Vars();
    private Vars() {}
    public static Vars instance() {
        return theInstance;
    }

    public boolean isCommand() {
      return true;
    }

    public SymbolicExpression eval(Environment vars) {
        return new Variable("vars");
    }

}
