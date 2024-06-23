package Set;
/* Given an integer array, print all distinct elements in an array. 
The given array may contain duplicates and the output should print 
every element only once. The given array is not sorted. */

import java.util.*;

public class DistinctElements{
    public static HashSet<Integer> printDistinct(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(printDistinct(nums));
        scan.close();
    }
}