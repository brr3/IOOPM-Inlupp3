package org.ioopm.calculator.ast;

public class Variable extends Atom {
    private String identifier;

    public Variable(String identifier){
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return this.identifier;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Variable) {
            return this.equals((Variable) other);
        } else {
            return false;
        }
    }

    public boolean equals(Variable other) {
        return this.identifier.equals(other.identifier);
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        Variable v = new Variable(this.identifier);
        if (vars.containsKey(v)) {
            System.out.println("variable found");
            if (vars.get(v).isConstant()) {
                    return new Constant(vars.get(v).getValue());
            } else {
                return v;
            }
        } else {
            System.out.println("variable not found");
            return v;
        }
    }
}
