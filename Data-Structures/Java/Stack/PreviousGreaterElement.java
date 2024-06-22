package Stack;
/* Given an array of distinct elements, find previous greater element for 
every element. If previous greater element does not exist, print -1. */

import java.util.*;

public class PreviousGreaterElement {
    public static Stack<Integer> previousGreater(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int prevMax = -1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                stk.push(nums[i-1]);
                if (prevMax < nums[i-1]) {
                    prevMax = nums[i-1];
                }
            } else if (prevMax < nums[i]) {
                prevMax = nums[i];
                stk.push(-1);
            } else {
                stk.push(prevMax);
            }
        }
        return stk;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(previousGreater(arr));
        scan.close();
    }
}
