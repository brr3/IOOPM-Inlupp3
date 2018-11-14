package org.ioopm.calculator.ast;

public class Assignment extends Binary {

    public Assignment(SymbolicExpression lhs, SymbolicExpression rhs) {
        super(lhs, rhs);
    }

    public String getName() {
        return "=";
    }

    public int getPriority() {
        return 0;
    }

    public SymbolicExpression eval() {
        SymbolicExpression lhs = this.getLhs().eval();
        if (lhs.isConstant()) {
            return new Constant(lhs.getValue());
        } else {
            return new Assignment(lhs, this.getRhs());
        }
    }

}
