/* Given two arrays arr1 and arr2, the elements of arr2 are distinct, 
and all elements in arr2 are also in arr1. Sort the elements of arr1 
such that the relative ordering of items in arr1 are the same as in arr2. 
Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order. */

import java.util.*;

public class SortAccordingToOther {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> sortedList = new ArrayList<>();
        for (int num : arr2) {
            if (frequencyMap.containsKey(num)) {
                int count = frequencyMap.get(num);
                for (int i = 0; i < count; i++) {
                    sortedList.add(num);
                }
                frequencyMap.remove(num);
            }
        }
        List<Integer> remainingElements = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                remainingElements.add(num);
            }
        }
        Collections.sort(remainingElements);
        sortedList.addAll(remainingElements);
        int[] result = new int[arr1.length];
        for (int i = 0; i < sortedList.size(); i++) {
            result[i] = sortedList.get(i);
        }
        return result;
    }

    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i=0; i<m; i++) {
            arr1[i] = scan.nextInt();
        }
        for (int j=0; j<n; j++) {
            arr2[j] = scan.nextInt();
        }
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        scan.close();
    }
}
