package com.ajaymourya.questions.stack;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */

class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return output.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (output.empty())
            while (!input.isEmpty())
                output.push(input.pop());
        return output.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
