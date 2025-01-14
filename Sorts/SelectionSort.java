package Sorts;
import java.util.Arrays;

public class SelectionSort {

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static int[] selectionSort(int[] data) {
        // Set `out` to be the baseline (min) of comparison
        for (int out = 0; out < data.length - 1; out++) {
            int min = out;
            for (int in = out + 1; in < data.length; in++) {
                if (data[in] < data[min]) {
                    min = in;
                }
            }

            if (min != out) {
                swap(data, min, out);
            }
            
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = {8,3,5,4,1,2,7,6,9};
        System.out.println(Arrays.toString(selectionSort(data)));
        // Expect [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}