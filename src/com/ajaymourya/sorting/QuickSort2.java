package com.ajaymourya.sorting;

import java.util.Arrays;

// Rightmost element as pivot
public class QuickSort2 {

    private int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = array[(left + right) / 2];
            int index = partition(array, left, right, pivot);
            quickSort(array, left, index - 1);
            quickSort(array, index, right);
        }
    }

    public static void main(String[] args) {
        int[] data = {-2, 45, 0, 11, -9};
        QuickSort2 sort = new QuickSort2();
        sort.quickSort(data, 0, data.length - 1);
        System.out.println("Sorted list");
        System.out.println(Arrays.toString(data));
    }
}
