/*************************************************
File: Expression Driver
By: Igor Tello
Date: 2/21
Compile: 
Usage: 
System: 
Description: Computes Postfix equations with any string as a parameter, returns an int.
*************************************************/

package ExpressionEvaluator;
import java.util.*;

public class PostFixEvaluator {
    private static final String operators= "+-*/^";
    private static Stack<Integer> valuesStack;

    public static int evaluatePostfix(String str){
        String character;
        Scanner parser = new Scanner(str);
        int operand1, operand2, result = 0;

        while (parser.hasNext()){

            character = parser.next();
            char x = character.charAt(0);
            
            if (operators.contains(character)){
                operand2 = (valuesStack.pop());
                operand1 = (valuesStack.pop());
                result = evaluate(x, operand1, operand2);
                valuesStack.push(result);
            }
            else {
                valuesStack.push(Integer.parseInt(character));
            }

        }
        parser.close();
        return result;
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
                result = op1 / op2;
                break;
            case '^':
                result = op1 ^ op2;
                break;
        }

        return result;
    }


}
