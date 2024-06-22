/* A total of n people are standing in a circle, and you are one of them playing a game. 
Starting from a person, k persons will be counted in order along the circle, 
and the kth person will be killed. Then the next k persons will be counted along the circle, 
and again the kth person will be killed. This cycle will continue until 
only a single person is left in the circle. */

import java.util.*;

public class JosephusProblem {
    public static int Josephus(LinkedList<Integer> nums, int start, int k) {
        if (nums.size() == 1) {
            return nums.get(0);
        }
        start = (start + k) % nums.size();
        nums.remove(start);
        return Josephus(nums, start, k);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> nums = new LinkedList<>();
        int n = scan.nextInt();
        int k = scan.nextInt();
        for (int i=1;i<=n;i++) {
            nums.add(i);
        }
        System.out.println(Josephus(nums, 0, k-1));
        scan.close();
    }
}