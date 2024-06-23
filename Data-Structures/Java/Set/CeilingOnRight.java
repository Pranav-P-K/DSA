package Set;
/* Given an array of integers, find the closest greater element 
for every element. If there is no greater element then print -1 */

import java.util.*;

public class CeilingOnRight {
    public static int[] ceilingsRight(int[] nums) {
        int n = nums.length;
        int[] ceilings = new int[n];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = n - 1; i >= 0; i--) {
            Integer ceiling = treeSet.ceiling(nums[i]);
            if (ceiling != null) {
                ceilings[i] = ceiling;
            } else {
                ceilings[i] = -1;
            }
            treeSet.add(nums[i]);
        }
        return ceilings;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(ceilingsRight(nums)));
        scan.close();
    }
}
