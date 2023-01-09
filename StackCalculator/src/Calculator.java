import java.util.Stack;
import java.util.stream.*;
public class Calculator {

    //Extra features: Exponent, Factorial, Logarithm

    public Stack<String> calculator(String[] n){
        Stack<String> stk = new Stack<String>();
        for (int i = 0; i <= n.length - 1; i++){
            stk.push(n[i]);
            if (n[i].equals("+")){
                stk.pop();
                stk.push((Integer.parseInt(stk.pop()) + Integer.parseInt(stk.pop())) + "");
            }
            else if (n[i].equals("-")){
                stk.pop();
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(stk.pop());
                stk.push(b - a + "");
            }
            else if (n[i].equals("*")){
                stk.pop();
                stk.push((Integer.parseInt(stk.pop()) * Integer.parseInt(stk.pop())) + "");
            }
            else if (n[i].equals("/")){
                stk.pop();
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(stk.pop());
                stk.push(b / a + "");
            }
            else if (n[i].equals("^")){
                stk.pop();
                int a = Integer.parseInt(stk.pop());
                int b = Integer.parseInt(stk.pop());
                stk.push(Math.pow(b, a) + "");
            }
            else if (n[i].equals("!")){
                stk.pop();
                int a = Integer.parseInt(stk.pop());
                int sum = 1;
                if (a < 0){
                    stk.push(a + "");
                }
                else{
                    for (int j = 1; j <= a; j++){
                        sum *= j;
                    }
                    stk.push(sum + "");
                }
            }
            else if (n[i].equals("log")){
                stk.pop();
                stk.push(Math.log(Integer.parseInt(stk.pop())) + "");
            }
        }
        return stk;
    }

    public static void main(String[]args){
        Calculator runner = new Calculator();
        System.out.println("Please use +, -, *, /, ^, ! or log in the calculator. Other symbols will not be recognized. ");
        String n[] = {"1", "2", "-1", "!", "+"};
        System.out.println(runner.calculator(n).toString());
    }
}
