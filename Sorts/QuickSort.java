package Sorts;

import java.util.Arrays;

/**
 * QuickSort - "Divide and Conquer" Algorithm
 * 1. Partition the array or sub-arrays into left (smaller values) and right (larger values) groups
 * 2. Sort the left group
 * 3. Sort the right group
 */

public class QuickSort {

    // Helper method
    public static void quickSort(int[] unsorted) {
        quickSort(unsorted, 0, unsorted.length - 1);
    }

    // Quick Sort logic
    public static void quickSort(int[] unsorted, int l, int r) {
        // Base case
        if (l >= r) {
            return;
        }
        int pivot = unsorted[r];
        int partition = partition(unsorted, l, r, pivot);
        quickSort(unsorted, l, partition - 1);
        quickSort(unsorted, partition + 1, r);
    }

    // Partition logic
    public static int partition(int[] arr, int l, int r, int pivot) {
        int lp = l - 1; // inclusive
        int rp = r; // exclusive
        
        while (true) {
            while (arr[lp++] < pivot);
            while (rp > l && arr[--rp] > pivot);
            if (lp >= rp) {
                break;
            }
            swap(arr, lp, rp);
        }
        // Put pivot from r to the final sorted position at lp
        swap(arr, lp, r);
        return lp;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {8,3,5,4,1,2,7,6,9};
        quickSort(data);
        System.out.println(Arrays.toString(data));
        // Expect [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
