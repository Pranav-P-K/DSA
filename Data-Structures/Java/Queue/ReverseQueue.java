/* Given an integer k and a queue of integers, The task is to reverse 
the order of the first k elements of the queue, leaving the other 
elements in the same relative order. */

import java.util.*;

public class ReverseQueue {
    public static void reverseK(Queue<Integer> q, int k) {
        if (q == null || k <= 0 || k > q.size()) return;
        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<k; i++) {
            stk.push(q.poll());
        }
        while (!stk.isEmpty()) {
            q.add(stk.pop());
        }
        for (int j=0; j<q.size()-k; j++) {
            q.add(q.poll());
        }
        return;
    }    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = scan.nextInt();
        for (int i=0; i<n; i++) {
            q.add(scan.nextInt());
        }
        int k = scan.nextInt();
        reverseK(q, k);
        System.out.println(q);
        scan.close();
    }
}
