package leetCode.dailyQuestion.DesignCircularDeque;

import java.util.LinkedList;

class MyCircularDeque {

    private int size;
    private final LinkedList<Integer> list;
    private final int maxSize;

    public MyCircularDeque(int k) {
        list  = new LinkedList<>();
        size = 0;
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        }
        list.addFirst(value);
        size ++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        }
        list.addLast(value);
        size ++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        list.removeFirst();
        size --;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        list.removeLast();
        size --;
        return true;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return list.getFirst();
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}