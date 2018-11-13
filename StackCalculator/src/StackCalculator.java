
import java.util.Stack;
public class StackCalculator {


    public static void main(String[] args) {
        System.out.print(Evaluate("(3+5"));
    }
    //Checks if the the character in the string is a digit.
    private static boolean IsDigit(char c){
        return (c>= '0' && c<= '9');
    }
    //Checks if the character in the string is a sort of operator.
    private static boolean IsOperator(char c){
        return (c=='+' || c== '-' || c=='*' || c=='/' || c== '(' || c== ')');
    }

    //just gets the precedence of each of the operators.
    static int getRank (char c){
        switch (c)
        {
            case '+':
            case '-':   return 1;
            case '*':
            case '/':   return 2;
            case '(':
            case ')':   return 3;
            default:    return -1;
        }
    }
   public static int Solve(int a, int b,char c){
        if (c == '+') return a+b;
        if (c == '-') return a-b;
        if (c == '*') return a*b;
        return a/b;
    }

    public static int  Evaluate(String s){
        Stack<Integer> valuesStack = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        int values= 0;
        int position=0;

        while (position<s.length()){
            char spot = s.charAt(position);
            if (IsDigit(spot)){
                values = (values * 10) + (int)(spot -'0');
            }
            else if (IsOperator(spot)) {
                if (spot == '(') {
                    operators.push(spot);
                    values = 0;
                }
                else if (valuesStack.isEmpty()){
                    valuesStack.push(values);
                    operators.push(spot);
                    values = 0;
                }
                else if (spot == ')'){
                    valuesStack.push(values);
                    while(operators.peek() != '('){
                        spot = operators.pop();
                        values = valuesStack.pop();
                        int previous = valuesStack.pop();
                        values = Solve(previous,values,spot);
                        valuesStack.push(values);
                    }
                    operators.pop();
                    valuesStack.pop();
                }
                else {
                    char previous= operators.peek();
                    if (getRank(spot) > getRank(previous))
                    {
                        valuesStack.push(values);
                        operators.push(spot);
                        values=0;
                    }
                    else {
                        int previousvalue = valuesStack.pop();
                        char previousoperation = operators.pop();
                        previousvalue = Solve(previousvalue,values,previousoperation);
                        valuesStack.push(previousvalue);
                        operators.push(spot);
                        values=0;
                    }
                }
            }
            position++;
        }
        while (!operators.isEmpty()){
            int previous = valuesStack.pop();
            char spot = operators.pop();
            values = Solve(previous,values,spot);
        }
        return values;
    }

    }
