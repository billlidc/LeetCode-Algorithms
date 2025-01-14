package Sorts;
import java.util.Arrays;


public class BubbleSort {
    
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static int[] bubbleSort(int[] data) {
        // Set `out` to be the baseline (max) of comparison
        for (int out = data.length - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (data[in] > data[in + 1]) {
                    swap(data, in, in + 1);
                }
            }
        }
        
        return data;
    }

    public static void main(String[] args) {
        int[] data = {8,3,5,4,1,2,7,6,9};
        System.out.println(Arrays.toString(bubbleSort(data)));
        // Expect [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
