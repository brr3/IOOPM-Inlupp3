package org.ioopm.calculator.ast;

public class NamedConstant extends Atom {
    private String name;
    private double value;

    public NamedConstant(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public boolean isNamedConstant() {
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public SymbolicExpression eval(Environment vars) {
        return new Constant(this.value);
    }
}
