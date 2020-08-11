package com.ajaymourya.questions.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Example 2:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 */

class Matrix01 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = cur[0] + dir[i][0];
                int col = cur[1] + dir[i][1];
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                matrix[row][col] = matrix[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{row, col});
            }
        }
        return matrix;
    }
}

class Matrix01WithNoVisitedArray {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[]{r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }
}

/**
 * Brute force solution
 * <p>
 * -> create 2D array temp
 * -> iterate the matrix
 * -> if item is 0
 * -> add to temp
 * -> else
 * -> iterate over the entire matrix
 * -> find the distance of cell to the item abs(i - k) + abs(j - l)
 * -> add distance to temp temp[i][j] = min (temp[i][j], abs(i - k) + abs(j - l))
 * <p>
 * <p>
 * Time -> O((r * c) * (r * c))
 * Space -> O(r * c)
 * <p>
 * <p>
 * <p>
 * <p>
 * BFS Approach
 * <p>
 * Time -> O(r * c)
 * Space -> O(r * c) for the queue
 */
