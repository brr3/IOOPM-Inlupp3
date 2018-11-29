package org.ioopm.calculator.parser;

import org.ioopm.calculator.parser.CalculatorParser;
import org.ioopm.calculator.ast.*;
import java.io.IOException;

public class ParserDriver {
    public static void main(String[] args) {
        CalculatorParser p = new CalculatorParser();
        SymbolicExpression.Environment vars = new SymbolicExpression.Environment();

        System.out.println("Welcome to the parser!");

        while(true) {
            System.out.print("Please enter an expression: \n");

            try {
                SymbolicExpression result = p.parse();

                if(result.isCommand()) {
                    if (result.getName().equals("quit")) {
                        break;
                    } else if (result.getName().equals("vars")){
                        System.out.print(vars);
                    }
                } else {
                    System.out.print("result: " + result.eval(vars) + "\n");
                }

            } catch(SyntaxErrorException e) {
                System.out.print("Syntax Error: ");
                System.out.println(e.getMessage());
                continue;
            } catch(IllegalExpressionException e) {
                System.out.print("Error: ");
                System.out.println(e.getMessage());
                continue;
            } catch(IOException e) {
                System.err.println("IO Exception!");
                continue;
            }
        }


        /*
          System.out.print("Please enter an expression: ");

          try {
          SymbolicExpression result = p.parse();
          System.out.println("result: " + result);
          System.out.println("result: " + result.eval(vars));
          } catch(SyntaxErrorException e) {
          System.out.print("Syntax Error: ");
          System.out.println(e.getMessage());
          } catch(IllegalExpressionException e) {
          System.out.print("Error: ");
          System.out.println(e.getMessage());
          } catch(IOException e) {
          System.err.println("IO Exception!");
          }*/
    }
}
