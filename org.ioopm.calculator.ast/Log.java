package org.ioopm.calculator.ast;

public class Log extends Unary {

    public Log(SymbolicExpression lhs) {
      super(lhs);
    }

    public String getName() {
        return "log";
    }
}
