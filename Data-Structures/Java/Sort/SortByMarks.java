/* There is a class with m students and n exams. You are given a 
0-indexed m x n integer matrix score, where each row represents one student 
and score[i][j] denotes the score the ith student got in the jth exam. 
The matrix score contains distinct integers only. You are also given an integer k. 
Sort the students (i.e., the rows of the matrix) by their scores in the 
kth (0-indexed) exam from the highest to the lowest.
Return the matrix after sorting it. */

import java.util.*;

public class SortByMarks {
    public static int[][] sortMarks(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] nums = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                nums[i][j] = scan.nextInt();
            }
        }
        int k = scan.nextInt();
        for (int[] x : sortMarks(nums, k)) {
            System.out.println(Arrays.toString(x));
        }
        scan.close();
    }
}
