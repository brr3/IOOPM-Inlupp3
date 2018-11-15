package org.ioopm.calculator.ast;

public class Subtraction extends Binary {

    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "-";
    }

    public int getPriority() {
        return 50;
    }

    public SymbolicExpression eval() {
        SymbolicExpression lhs = this.lhs.eval();
        SymbolicExpression rhs = this.rhs.eval();
        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() - rhs.getValue());
        } else if (lhs.isConstant()) {
            return new Subtraction(new Constant(lhs.getValue()), new Variable(rhs.toString()));
        } else {
            return new Subtraction(new Variable(lhs.toString()), new Constant(rhs.getValue()));
        }
    }

}
