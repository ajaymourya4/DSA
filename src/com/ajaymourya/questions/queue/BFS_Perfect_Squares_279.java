package com.ajaymourya.questions.queue;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * */

class PerfectSquares {
    public int numSquares(int n) {
        int numSquares = 0;

        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet<Integer>();
        q.add(0);
        visited.add(0);

        while (!q.isEmpty()) {
            int size = q.size();
            numSquares++;
            while (size > 0) {
                int num = q.poll();
                for (int i = 1; i * i <= n; i++) {
                    int x = num + i * i;
                    if (x == n) return numSquares;
                    if (x > n) break;
                    if (!visited.contains(x)) {
                        q.add(x);
                        visited.add(x);
                    }
                }
                size--;
            }
        }
        return numSquares;
    }
}
