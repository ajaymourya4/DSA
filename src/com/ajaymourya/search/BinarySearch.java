package com.ajaymourya.search;

public class BinarySearch {
    public int binarySearch(int[] array, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public int recursiveBinarySearch(int[] array, int x, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] < x)
                return recursiveBinarySearch(array, x, mid + 1, high);
            else
                return recursiveBinarySearch(array, x, low, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] array = {4, 8, 12, 32, 64, 88, 92};
        int result = search.binarySearch(array, 64, 0, array.length - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
