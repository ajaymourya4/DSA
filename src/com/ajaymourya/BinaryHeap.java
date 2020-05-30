package com.ajaymourya;

import java.util.ArrayList;

// the implementation is same for Priority Queue
public class BinaryHeap {

    void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && hT.get(l) > hT.get(largest))
            largest = l;
        if (r < size && hT.get(r) > hT.get(largest))
            largest = r;

        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);

            heapify(hT, largest);
        }
    }

    void insertNode(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if (size == 0)
            hT.add(newNum);
        else {
            hT.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--){
                heapify(hT, i);
            }
        }
    }

    void deleteNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;
        for (i = 0; i < size; i++){
            if (num == hT.get(i))
                break;
        }
        int temp = hT.get(i);
        hT.set(i, hT.get(size - 1));
        hT.set(size - 1, temp);
        hT.remove(size - 1);
        for (int j = size / 2 - 1; j >= 0; j--){
            heapify(hT, j);
        }
    }

    void printArray(ArrayList<Integer> hT) {
        for (Integer i : hT){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();

        BinaryHeap h = new BinaryHeap();
        h.insertNode(array, 3);
        h.insertNode(array, 4);
        h.insertNode(array, 9);
        h.insertNode(array, 5);
        h.insertNode(array, 2);

        System.out.println("Max-Heap array: ");
        h.printArray(array);

        h.deleteNode(array, 5 );
        System.out.println("After deleting an element: ");
        h.printArray(array);
    }
}
