/* Given an array arr[] consisting of the cost of toys and an 
integer K depicting the amount of money available to purchase toys. 
The task is to find the maximum number of toys one can buy with the amount K. */

import java.util.*;

public class PurchasingMaxItems {
    public static int maxItems(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
        }
        while (!minHeap.isEmpty() && minHeap.peek() <= k) {
            k -= minHeap.poll();
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        System.out.println(maxItems(nums, k));
        scan.close();
    }
}
