package Set;
/* Given an array of n integers. The task is to print the duplicates in the given array. */

import java.util.*;

public class RepeatingElements {
    public static HashSet<Integer> printRepeating(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            }
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
        System.out.println(printRepeating(nums));
        scan.close();
    }
}
