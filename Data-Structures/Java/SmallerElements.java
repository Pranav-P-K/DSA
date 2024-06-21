/* You are given an ArrayList of integers. Write a function in Java that, for each element in the list, 
finds how many elements to the right of that element are smaller than it. 
The function should return a new ArrayList containing these counts for each element. */

//import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

class SmallerElements {
    public static ArrayList<Integer> countSmallerElements(ArrayList<Integer> nums) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0;i<nums.size();i++) {
            int count = 0;
            for (int j=i;j<nums.size();j++) {
                if (nums.get(j) < nums.get(i)) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i=0;i<n;i++) {
            nums.add(scan.nextInt());
        }
        ArrayList<Integer> result = countSmallerElements(nums);
        System.out.println(result);
        scan.close();

    }
}
