/* Given an expression string exp, write a program to examine whether the pairs
and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression. */

import java.util.*;

public class BalancedParenthesis {
    public static boolean checkValid(String str) {
        Stack<Character> stk = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c=='(' || c=='[' || c=='{') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                char top = stk.peek();
                if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                    stk.pop();
                } else {
                    return false;
                }
            }

        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(checkValid(str));
        scan.close();
    }
}