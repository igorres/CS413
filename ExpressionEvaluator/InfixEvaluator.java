/*************************************************
File: Expression Driver
By: Igor Tello
Date: 2/21
Compile: 
Usage: 
System: 
Description: Computes Infix equations with any string as a parameter, returns an int.
*************************************************/

package ExpressionEvaluator;
import java.util.*;

public class InfixEvaluator {
    private static final String operators= "+-*/()[]";

    private static Stack<Integer> valueStack;
    private static Stack<Character> operatorStack;

    public static int evaluateInfix(String str){
        Scanner parser = new Scanner(str);
        String character;
        Character topOperator;
        int operand1, operand2, result = 0;

        while (parser.hasNext()){

            character = parser.next();
            char x = character.charAt(0);

            if (character == "^"){
                operatorStack.push(x);
            }
            else if(operators.contains(character)){ //character is an operator
                while (!operatorStack.isEmpty() && precedence(x) <= precedence(operatorStack.peek())){
                    topOperator = operatorStack.pop();
                    operand2 = valueStack.pop();
                    operand1 = valueStack.pop();
                    result = evaluate(topOperator, operand1, operand2);
                    valueStack.push(result);
                }
                operatorStack.push(x);
            }
            else if(character == "("){
                operatorStack.push(x);
            }
            else if(character == ")"){
                topOperator = operatorStack.pop();
                while (topOperator != '('){
                    operand2 = valueStack.pop();
                    operand1 = valueStack.pop();
                    result = evaluate(x, operand1, operand2);
                    valueStack.push(result);
                    topOperator = operatorStack.pop();
                }
            }
            else{
                valueStack.push(Integer.parseInt(character));
            }
        }
        while (!operatorStack.isEmpty()){
            topOperator = operatorStack.pop();
            operand2 = valueStack.pop();
            operand1 = valueStack.pop();
            result = evaluate(topOperator, operand1, operand2);
            valueStack.push(result);
        }
        parser.close();
        return valueStack.peek();
    }

    private static int evaluate(char operator, int op1, int op2){
        int result = 0;

        switch (operator){
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                if (op2 == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by 0");
                result = op1 / op2;
                break;
            case '^':
                result = op1 ^ op2;
                break;
        }

        return result;
    }

    private static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    
}
