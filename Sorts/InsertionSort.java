package Sorts;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] data) {

        for (int out = 1; out < data.length; out++) {
            int temp = data[out];
            int in = out;
            while (in > 0 && data[in - 1] > temp) {
                data[in] = data[in - 1];
                in--;
            }

            if (out != in) {
                data[in] = temp;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {8,3,5,4,1,2,7,6,9};
        System.out.println(Arrays.toString(insertionSort(data)));
        // Expect [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
