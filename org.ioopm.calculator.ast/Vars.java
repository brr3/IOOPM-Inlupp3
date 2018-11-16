package org.ioopm.calculator.ast;

public class Vars extends Command {

    public SymbolicExpression eval(Environment vars) {
        return new Variable("vars");
    }

}
