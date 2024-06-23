/* Given an array of N numbers and a positive integer K. 
The problem is to find K numbers with the most occurrences, i.e., 
the top K numbers having the maximum frequency. If two numbers 
have the same frequency then the number with a larger value 
should be given preference. The numbers should be displayed in 
decreasing order of their frequencies. It is assumed that the 
array consists of at least K numbers. */

import java.util.*;

public class KMostFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> 
                a.getValue() == b.getValue() ? b.getKey() - a.getKey() : b.getValue() - a.getValue());
        pq.addAll(count.entrySet());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        System.out.println(topKFrequent(nums, k));
        scan.close();
    }
}
