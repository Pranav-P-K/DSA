/* Given text string with length n and a pattern with length m, 
the task is to prints the first occurrence of pattern in text. */

import java.util.*;

public class PatternSearch {
    public static int search(String str, String txt) {
        int m = str.length();
        int n = txt.length();
        for (int i=0; i<m-n; i++) {
            int j=0;
            for (j=0; j<n; j++) {
                if (str.charAt(i+j) != txt.charAt(j)) {
                    break;
                }
            }
            if (j==n) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String txt = scan.next();
        System.out.println(search(str, txt));
        scan.close();
    }
}
