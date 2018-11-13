package org.ioopm.calculator.ast;

public class Exp extends Unary {

    public Exp(SymbolicExpression lhs) {
        super(lhs);
    }

    public String getName() {
        return "^";
    }
}
