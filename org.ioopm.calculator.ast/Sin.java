package org.ioopm.calculator.ast;

public class Sin extends Unary {

    public Sin(Atom atom){

    }

    public Sin(Unary unary){

    }

    public String getName() {
        return "sin";
    }

}
