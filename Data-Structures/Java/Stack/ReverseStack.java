package Stack;
// To reverse a stack using another stack

import java.util.*;

public class ReverseStack{
    public static Stack<Integer> reverse(Stack<Integer> stk) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stk.isEmpty()) {
            tempStack.push(stk.pop());
        }
        stk = tempStack;
        return stk;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        int n = scan.nextInt();
        for (int i=0;i<n;i++) {
            stk.push(scan.nextInt());
        }
        stk = reverse(stk);
        System.out.print(stk);
        scan.close();
    }
}