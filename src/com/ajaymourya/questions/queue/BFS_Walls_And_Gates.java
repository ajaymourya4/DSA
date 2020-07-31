package com.ajaymourya.questions.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example :
 *   INF   -1     0    INF
 *   INF   INF   INF   -1
 *   INF   -1    INF   -1
 *   0     -1    INF   INF
 *
 * Output :
 *   3  -1  0   1
 *   2   2  1  -1
 *   1  -1  2  -1
 *   0  -1  3   4
 * */

class WallsAndGates {

    private final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] room = queue.poll();
            int distance = rooms[room[0]][room[1]];

            for (int i = 0; i < 4; i++) {
                int row = room[0] + DIRECTIONS[i][0];
                int col = room[1] + DIRECTIONS[i][1];

                if (row >= 0 && row < rooms.length && col >= 0 && col < rooms[0].length) {
                    if (rooms[row][col] == Integer.MAX_VALUE) {
                        rooms[row][col] = distance + 1;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }
    }
}
