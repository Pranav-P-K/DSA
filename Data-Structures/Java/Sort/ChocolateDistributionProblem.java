/* Given an array of N packets of chocolates, where each packet has a 
certain number of chocolates, and M students. Distribute the packets 
such that the difference between the number of chocolates in the packet 
with the most chocolates and the packet with the least chocolates is minimized. */

import java.util.*;

public class ChocolateDistributionProblem {
    public static int distribute(int[] nums, int m) {
        int n = nums.length;
        if (m==0 || n==0) return 0;
        if (n < m) return -1;
        Arrays.sort(nums);
        int minDiff = nums[n-1];
        for (int i=0; i+m-1<n; i++) {
            int diff = nums[i+m-1] - nums[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        System.out.println(distribute(arr, m));
        scan.close();
    }
}