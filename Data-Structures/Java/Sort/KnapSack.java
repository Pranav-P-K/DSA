/*  */

import java.util.*;

public class KnapSack {
    public static double getMaxValue(int[] weights, int[] values, int capacity) {
        int n = values.length;
        Double[][] ratio = new Double[n][2];
        for (int i = 0; i < n; i++) {
            ratio[i][0] = (double) values[i] / weights[i];
            ratio[i][1] = (double) i;
        }
        Arrays.sort(ratio, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] a, Double[] b) {
                return b[0].compareTo(a[0]);
            }
        });
        double totalValue = 0.0;
        for (int i = 0; i < n; i++) {
            int index = ratio[i][1].intValue();
            if (capacity - weights[index] >= 0) {
                capacity -= weights[index];
                totalValue += values[index];
            } else {
                totalValue += values[index] * ((double) capacity / weights[index]);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] weights = new int[n];
        int[] values = new int[n];
        for (int i=0; i<n; i++) {
            weights[i] = scan.nextInt();
        }
        for (int j=0; j<n; j++) {
            values[j] = scan.nextInt();
        }
        int cap = scan.nextInt();
        System.out.println(getMaxValue(weights, values, cap));
        scan.close();
    }
}