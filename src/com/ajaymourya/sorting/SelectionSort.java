package com.ajaymourya.sorting;

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {-2, 45, 0, 11, -9};
        selectionSort(data);
        System.out.println("Sorted list");
        System.out.println(Arrays.toString(data));
    }
}
