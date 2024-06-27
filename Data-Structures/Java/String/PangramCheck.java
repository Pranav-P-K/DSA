/* Given string str, the task is to check whether the given string 
is a pangram or not. A string is a pangram string if it contains 
all the character of the alphabets ignoring the case of the alphabets. */

import java.util.*;

public class PangramCheck {
    public static boolean isPangram(String str) {
        str = str.toLowerCase();
        boolean[] alphaList = new boolean[26];
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                alphaList[ch - 'a'] = true;
            }
        }
        for (boolean bool : alphaList) {
            if (!bool) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(isPangram(str));
        scan.close();
    }
}