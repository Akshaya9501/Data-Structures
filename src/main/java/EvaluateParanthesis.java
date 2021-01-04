import java.util.Stack;

public class EvaluateParanthesis {

    public static boolean evaluate(String exp) {
        char[] array = exp.toCharArray();
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '{' || c == '(' || c == '[') {
                s.push(array[i]);
                continue;
            }
            if (s.isEmpty()) {
                return false;
            }
            char check;
            switch (c) {
                case '}':
                    check = s.pop();
                    if (check == '(' || check == '[')
                        return false;
                break;
                case ']':
                    check = s.pop();
                    if (check == '{' || check == '(')
                        return false;
                break;
                case ')':
                    check = s.pop();
                    if (check == '{' || check == '[')
                        return false;
                break;
            }
        }
return s.isEmpty();
    }

    public static void main(String args[]) {
        String expr = "([{}]";

        // Function call
        if (evaluate(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
