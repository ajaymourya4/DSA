package com.ajaymourya.search;

public class LinearSearch {

    public int LinearSearch(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch search = new LinearSearch();
        int[] array = {4, 9, 12, 8, 1, 0, 2};
        int result = search.LinearSearch(array, 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
