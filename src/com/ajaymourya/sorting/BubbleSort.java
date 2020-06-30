package com.ajaymourya.sorting;

import java.util.Arrays;

public class BubbleSort {
    public void bubbleSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public void optimizedBubbleSort(int[] array) {
        int size = array.length;
        boolean swapped = true;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = false;
                }
            if (swapped)
                break;
        }
    }

    public static void main(String[] args) {
        int[] data = {-2, 45, 0, 11, -9};
        BubbleSort sort = new BubbleSort();
        sort.bubbleSort(data);
        System.out.println("Sorted list");
        System.out.println(Arrays.toString(data));
    }
}
