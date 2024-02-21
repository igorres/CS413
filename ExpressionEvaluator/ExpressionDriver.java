/*************************************************
File: Expression Driver
By: Igor Tello
Date: 2/21
Compile: 
Usage: 
System: 
Description: Takes 4 numbers as input and computes Infix and Postfix equations
            of the expressions (a+b)*(c+d) and ac-b^d+ .
*************************************************/



package ExpressionEvaluator;
import java.util.*;

public class ExpressionDriver {
    private static final String infix = "(a+b)*(c+d)";
    private static final String postfix = "ac-b^d+";

    static Scanner input = new Scanner(System.in);
    private static String input1, input2, input3, input4;
    private static boolean compute = true;

    private static int evaluateInfix(String str) {
        InfixEvaluator infix = new InfixEvaluator();
        return infix.evaluateInfix(str);

    }

    private static int evaluatePostfix(String str) {
        PostFixEvaluator postfix = new PostFixEvaluator();
        return postfix.evaluatePostfix(str);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while (compute != false){
            System.out.println("Is computing needed?");
            String response = input.nextLine();
            if (response.equalsIgnoreCase("yes")){
                System.out.println("Enter in four values, one value at a time followed by Enter.");
                input1 = input.nextLine();
                input2 = input.nextLine();
                input3 = input.nextLine();
                input4 = input.nextLine();

                String infixString = "("+input1 + "+" + input2 + ")" + "*" + "(" + input3 + "+" + input4 + ")";
                String postfixString = input1 + input3 + "-" + input2 + "^" + input4 + "+";

                int resultInfix = evaluateInfix(infixString);
                int resultPostfix = evaluatePostfix(postfixString);
    
                System.out.println("Value of infix string " + infix + " with a = " + input1 + ", b = " + input2 + ", c = " + input3 + ", d = " + input4 + " is " + resultInfix);
                System.out.println("Value of postfix string " + postfix + " with a = " + input1 + ", b = " + input2 + ", c = " + input3 + ", d = " + input4 + " is " + resultPostfix);
            }
            else{
                compute = false;
                System.out.println(response);
                input.close();
            }
        }

    }   
    
}
