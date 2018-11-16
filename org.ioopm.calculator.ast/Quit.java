package org.ioopm.calculator.ast;

public class Quit extends Command {

    public SymbolicExpression eval(Environment vars) {
        return new Variable("quit");
    }

}
