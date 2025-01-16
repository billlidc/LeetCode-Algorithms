package Sorts;

import java.util.Arrays;


/**
 * Merge Sort - "Divide and Conquer" Algorithm
 * 1. Sort the first half using merge sort
 * 2. Sort the second half using merge sort
 * 3. Merge the sorted two halves
 */

public class MergeSort {
    public static int[] merge(int[] a, int[] b){
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, m = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                merged[m++] = a[i++];
            } else {
                merged[m++] = b[j++];
            }
        }
        if (i < a.length) {
            while (i < a.length) {
                merged[m++] = a[i++];
            }
        }
        if (j < b.length) {
            while (j < b.length) {
                merged[m++] = b[j++];
            }
        }
        return merged;
    }

    public static int[] mergeSort(int[] unsorted) {
        // Base case
        if (unsorted.length <= 1) {
            return unsorted;
        }
        
        // Split into two halves
        int mid = unsorted.length / 2;

        int[] a = new int[mid];
        System.arraycopy(unsorted, 0, a, 0, mid);
        int[] b = new int[unsorted.length - mid];
        System.arraycopy(unsorted, mid, b, 0, unsorted.length - mid);

        // Sort the two halves
        a = mergeSort(a);
        b = mergeSort(b);

        // Merge the two halves
        return merge(a, b);
    }

    public static void main(String[] args) {
        int[] unsorted = {8,3,5,4,1,2,7,6,9};
        System.out.println(Arrays.toString(mergeSort(unsorted)));
        // Expect [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
