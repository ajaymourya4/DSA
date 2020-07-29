package com.ajaymourya.questions.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given a stream of integers and a window size,
* calculate the moving average of all integers in the sliding window.
* */

class MovingAverage {
    Queue<Integer> queue;
    int size;
    double sum;

    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() <= size) {
            return sum/queue.size();
        }
        sum -= queue.poll();
        return sum/size;
    }
}

/*
* sliding window concept
* usage of queue to maintain the data stream
* */
