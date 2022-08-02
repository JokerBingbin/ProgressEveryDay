package leetCode.dailyQuestion.MyCircularQueue;

import java.util.LinkedList;

class MyCircularQueue {

    private int size;
    private final LinkedList<Integer> list;
    private final int maxSize;

    public MyCircularQueue(int k) {
        list = new LinkedList<>();
        size = 0;
        maxSize = k;
    }

    public boolean enQueue(int value) {
        if (size == maxSize) {
            return false;
        }
        list.addFirst(value);
        size ++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        list.remove(size - 1);
        size --;
        return true;
    }

    public int Front() {
        if (size == 0) {
            return -1;
        }
        return list.get(size - 1);
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}
