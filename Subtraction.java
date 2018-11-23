package org.ioopm.calculator.ast;

public class Subtraction extends Binary {

    public Subtraction(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override
    public int getPriority() {
        return 50;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        SymbolicExpression lhs = this.lhs.eval(vars);
        SymbolicExpression rhs = this.rhs.eval(vars);
        if (lhs.isConstant() && rhs.isConstant()) {
            return new Constant(lhs.getValue() - rhs.getValue());
        } else if (lhs.isConstant()) {
            return new Subtraction(new Constant(lhs.getValue()), new Variable(rhs.toString()));
        } else {
            return new Subtraction(new Variable(lhs.toString()), new Constant(rhs.getValue()));
        }
    }

}
