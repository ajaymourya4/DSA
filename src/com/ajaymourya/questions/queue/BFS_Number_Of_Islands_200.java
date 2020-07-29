package com.ajaymourya.questions.queue;

/*
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
* You may assume all four edges of the grid are all surrounded by water.
*
* Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
  ]
*
* Output: 1*/

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int numIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    BFS(grid, visited, i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void BFS(char[][] mat, boolean[][] visited, int m, int n) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(m, n));
        visited[m][n] = true;

        while (queue.size() != 0) {
            int x = queue.peek().x;
            int y = queue.peek().y;
            queue.remove();

            for (int k = 0; k < 4; k++) {
                if (isSafe(mat, visited, x + row[k], y + col[k])) {
                    visited[x + row[k]][y + col[k]] = true;
                    queue.add(new Pair(x + row[k], y + col[k]));
                }
            }
        }
    }

    public boolean isSafe(char[][] mat, boolean[][] visited, int x, int y) {
        return (x >= 0 && x <= mat.length && y >= 0 && y < mat[0].length && mat[x][y] == '1' && !visited[x][y]);
    }

    public static int[] row = {-1, 0, 1, 0};
    public static int[] col = {0, 1, 0, -1};

    class Pair {
        int x;
        int y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }
    }

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        System.out.println(n.numIslands(grid));
    }
}
