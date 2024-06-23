package Set;
/* Given an array arr of integers of size N, the task is to find, 
for every element, the number of elements that are greater than it. */

import java.util.*;

public class CountGreaterElements {
    public static int[] countGreater(int[] nums) {
        int[] count = new int[nums.length];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            treeSet.add(nums[i]);
        }
        for (int j=0; j<nums.length; j++) {
            count[j] = treeSet.tailSet(nums[j],false).size();
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
        System.out.println(Arrays.toString(countGreater(nums)));
        scan.close();
    }
}
