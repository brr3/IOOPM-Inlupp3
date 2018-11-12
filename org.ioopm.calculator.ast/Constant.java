package org.ioopm.calculator.ast;

public class Constant extends Atom {
    private double value;

    public Constant(double value){
        this.value = value;
    }

    public boolean isConstant() {
        return true;
    }

    public String getName() {
        throw new RuntimeException("getname() called on expression with no operator");
    }
}
