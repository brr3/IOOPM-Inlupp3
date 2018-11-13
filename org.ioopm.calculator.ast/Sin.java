package org.ioopm.calculator.ast;

public class Sin extends Unary {

    public Sin(SymbolicExpression lhs) {
        super(lhs);
    }

    public String getName() {
        return "sin";
    }

}
