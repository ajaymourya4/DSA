package com.ajaymourya.questions.DFS;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * <p>
 * Example 2:
 * <p>
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 */

class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            List<Integer> keys = rooms.get(stack.pop());
            for (int key : keys) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    stack.push(key);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
