package org.ioopm.calculator.ast;

public class Exp extends Unary {


    public String getName() {
        throw new RuntimeException("getname() called on expression with no operator");
    }

}
