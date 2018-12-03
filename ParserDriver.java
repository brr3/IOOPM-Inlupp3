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
            SymbolicExpression result;

            try {
                String input = System.console().readLine();
                result = p.parse(input);

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
    }
}
