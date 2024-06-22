/* Given an array arr[] of size N, the task is to printing K largest elements in an array. */

import java.util.*;

public class KLargestElements {
    public static PriorityQueue<Integer> findKLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        System.out.println(findKLargest(nums, k));
        scan.close();
    }
}
