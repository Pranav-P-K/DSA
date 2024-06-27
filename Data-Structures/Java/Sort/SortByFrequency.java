/* Given an array of integers nums, sort the array in increasing order 
based on the frequency of the values. If multiple values have the same frequency, 
sort them in decreasing order. Return the sorted array. */

import java.util.*;

public class SortByFrequency {
    public static int[] sortFrequency(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int freqCompare = frequencyMap.get(b).compareTo(frequencyMap.get(a));
                if (freqCompare == 0) {
                    return a.compareTo(b); // natural order if frequencies are equal
                }
                return freqCompare;
            });
        maxHeap.addAll(frequencyMap.keySet());
        int[] sortedList = new int[nums.length];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            int current = maxHeap.poll();
            for (int i = 0; i < frequencyMap.get(current); i++) {
                sortedList[index++] = current;
            }
        }
        return sortedList;
    } 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(sortFrequency(nums)));
        scan.close();
    }
}
