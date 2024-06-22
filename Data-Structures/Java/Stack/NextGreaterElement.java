package Stack;
/* The next greater element of some element x in an array is the first 
greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, 
where nums1 is a subset of nums2. For each 0 <= i < nums1.length, 
find the index j such that nums1[i] == nums2[j] and determine the next 
greater element of nums2[j] in nums2. If there is no next greater element, 
then the answer for this query is -1. Return an array ans of length nums1.length 
such that ans[i] is the next greater element as described above. */

import java.util.*;

public class NextGreaterElement {
    public static   int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i : nums2) {
            while(!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            } 
            stack.push(i);
        }
        for(int i=0; i<n; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i=0; i<m; i++) arr1[i] = scan.nextInt();
        for (int j=0; j<n; j++) arr2[j] = scan.nextInt();
        int ans[] = nextGreaterElement(arr1,arr2);
        for (int k=0; k<ans.length; k++) {
            System.out.print(ans[k] + " ");
        }
        scan.close();
    }
}
