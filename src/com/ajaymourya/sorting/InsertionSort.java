package com.ajaymourya.sorting;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] data = {-2, 45, 0, 11, -9};
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(data);
        System.out.println("Sorted list");
        System.out.println(Arrays.toString(data));
    }
}
