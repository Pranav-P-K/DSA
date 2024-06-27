/* Given a string str containing only lowercase characters. 
The task is to print the characters along with their frequencies 
in the order of their occurrence in the given string. */

import java.util.*;

public class PrintFrequency {
    public static void charFrequency(String str) {
        Map<Character,Integer> hashMap = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch,0)+1);
        }
        hashMap.forEach(
            (key,val) -> System.out.println(key + ":" + val));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        charFrequency(str);
        scan.close();
    }
}