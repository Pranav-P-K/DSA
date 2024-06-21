/* The stock span problem is a financial problem where we have a series
of N daily price quotes for a stock and we need to calculate the span of 
the stock’s price for all N days. The span Si of the stock’s price on a 
given day i is defined as the maximum number of consecutive days just 
before the given day, for which the price of the stock on the current day 
is less than or equal to its price on the given day.  */

import java.util.*;

public class StockSpan {

    public static Stack<Integer> calculateSpan(int[] nums, int n) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        for (int i=1; i<n; i++) {
            int c = 1;
            for (int j=i-1; (j >= 0) && (nums[i] >= nums[j]); j--) {c++;}
            stk.push(c);
        }
        return stk;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(calculateSpan(nums, n));
        scan.close();
    }
}
