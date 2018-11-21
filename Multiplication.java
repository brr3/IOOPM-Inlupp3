package org.ioopm.calculator.ast;

public class Multiplication extends Binary {

    public Multiplication(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "*";
    }

    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression lhs = this.lhs.eval(vars);
        SymbolicExpression rhs = this.rhs.eval(vars);
        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() * rhs.getValue());
        } else if (lhs.isConstant()) {
            return new Multiplication(new Constant(lhs.getValue()), new Variable(rhs.toString()));
        } else {
            return new Multiplication(new Variable(lhs.toString()), new Constant(rhs.getValue()));
        }
    }

}
