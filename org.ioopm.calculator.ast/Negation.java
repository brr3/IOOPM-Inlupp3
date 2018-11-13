package org.ioopm.calculator.ast;

public class Negation extends Unary {

    public Negation(SymbolicExpression lhs) {
        super(lhs);
    }

    public String getName() {
        return "-";
    }

}
