package com.ajaymourya;

class node {
    node parent;
    node left;
    node right;
    node child;
    int degree;
    boolean mark;
    int key;

    public node() {
        this.degree = 0;
        this.mark = false;
        this.parent = null;
        this.left = this;
        this.right = this;
        this.child = null;
        this.key = Integer.MAX_VALUE;
    }

    node(int key) {
        this();
        this.key = key;
    }

    public node get_parent() {
        return parent;
    }

    public void set_parent(node parent) {
        this.parent = parent;
    }

    public node get_left() {
        return left;
    }

    public void set_left(node left) {
        this.left = left;
    }

    public node get_right() {
        return right;
    }

    public void set_right(node right) {
        this.right = right;
    }

    public node get_child() {
        return child;
    }

    public void set_child(node child) {
        this.child = child;
    }

    public int get_degree() {
        return degree;
    }

    public void set_degree(int degree) {
        this.degree = degree;
    }

    public boolean get_mark() {
        return mark;
    }

    public void set_mark(boolean mark) {
        this.mark = mark;
    }

    public int get_key() {
        return key;
    }

    public void set_key(int key) {
        this.key = key;
    }
}

public class FibHeap {
    node min;
    int n;
    boolean trace;
    node found;

    public boolean get_trace() {
        return trace;
    }

    public void set_trace(boolean t) {
        this.trace = t;
    }

    public static FibHeap create_heap() {
        return new FibHeap();
    }

    FibHeap() {
        min = null;
        n = 0;
        trace = false;
    }

    private void insert(node x) {
        if (min == null) {
            min = x;
            x.set_left(min);
            x.set_right(min);
        } else {
            x.set_right(min);
            x.set_left(min.get_left());
            min.get_left().set_right(x);
            min.set_left(x);
            if (x.get_key() < min.get_key())
                min = x;
        }
        n += 1;
    }

    public void insert(int key) {
        insert(new node(key));
    }

    public void display() {
        display(min);
        System.out.println();
    }

    private void display(node c) {
        System.out.print("(");
        if (c == null) {
            System.out.print(")");
            return;
        } else {
            node temp = c;
            do {
                System.out.print(temp.get_key());
                node k = temp.get_child();
                display(k);
                System.out.print("->");
                temp = temp.get_right();
            } while (temp != c);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        FibHeap obj = create_heap();
        obj.insert(7);
        obj.insert(26);
        obj.insert(30);
        obj.insert(39);
        obj.insert(10);
        obj.display();
    }
}
