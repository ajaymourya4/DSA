package com.ajaymourya.sorting;

import java.util.Arrays;

public class QuickSort {

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] data = {-2, 45, 0, 11, -9};
        QuickSort sort = new QuickSort();
        sort.quickSort(data, 0, data.length - 1);
        System.out.println("Sorted list");
        System.out.println(Arrays.toString(data));
    }
}
