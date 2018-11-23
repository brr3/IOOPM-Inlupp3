package org.ioopm.calculator.ast;

public class Vars extends Command {
    private static final Vars theInstance = new Vars();
    private Vars() {}
    public static Vars instance() {
        return theInstance;
    }

    @Override
    public boolean isCommand() {
      return true;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        return new Variable("vars");
    }

}
