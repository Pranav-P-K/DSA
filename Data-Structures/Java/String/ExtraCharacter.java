/* Given two strings which are of lengths n and n+1. 
The second string contains all the characters of the first string, 
but there is one extra character. Your task is to find the extra 
character in the second string. */

import java.util.Scanner;

public class ExtraCharacter {
    public static char findExtra(String str1, String str2) {
        int xor = 0;
        for (int i = 0; i < str1.length(); i++) {
            xor ^= str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++) {
            xor ^= str2.charAt(i);
        }
        return (char) xor;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        System.out.println(findExtra(str1, str2));
        scan.close();
    }
}
