package com.ajaymourya.sorting;

import java.util.Arrays;

public class MergeSort {

    public void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (i = start; i <= end; i++)
            arr[i] = temp[i - start];
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] data = {-2, 45, 0, 11, -9};
        MergeSort sort = new MergeSort();
        sort.mergeSort(data, 0, data.length - 1);
        System.out.println("Sorted list");
        System.out.println(Arrays.toString(data));
    }
}
