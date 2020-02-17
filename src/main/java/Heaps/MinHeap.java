package Heaps;

import java.util.Arrays;

public class MinHeap {

    private int maxSize = 10;
    private int size = 0;
    private int[] items = new int[maxSize];

    public int peek() {
        if (size == 0) {
            return -1;
        }
        return items[0];
    }

    public int poll() {
        if (size == 0) {
            return -1;
        }
        int item = items[0];
        items[0] = items[size - 1]; // the last element becomes the first in removal
        items[size - 1] = 0; // to not wait for override
        size--;
        heapifyDown(); // adjust our heap accordingly, after adding last as first
        return item;
    }

    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int idx = size - 1;
        // whilst parent bigger -> out of order
        while (hasParent(idx) && parent(idx) > items[idx]) {
            swap(getParentIdx(idx), idx);
            idx = getParentIdx(idx);
        }
    }

    private void heapifyDown() {
        int idx = 0;
        while (hasLeftChild(idx)) {
            int smallerChildIdx = getSmallestIdx(idx);
            if (items[idx] < items[smallerChildIdx]) {
                break;
            } else {
                swap(idx, smallerChildIdx);
                idx = smallerChildIdx;
            }

        }
    }

    private int getSmallestIdx(int idx) {
        if (hasRightChild(idx) && rightChild(idx) < leftChild(idx)) {
            return getRightChildIdx(idx);
        }
        return getLeftChildIdx(idx);
    }

    private int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    private int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    private int getParentIdx(int childIdx) {
        return (childIdx - 1) / 2;
    }

    private boolean hasLeftChild(int idx) {
        return getLeftChildIdx(idx) < size;
    }

    private boolean hasRightChild(int idx) {
        return getRightChildIdx(idx) < size;
    }

    private boolean hasParent(int idx) {
        return getParentIdx(idx) >= 0;
    }

    private int leftChild(int idx) {
        return items[getLeftChildIdx(idx)];
    }

    private int rightChild(int idx) {
        return items[getRightChildIdx(idx)];
    }

    private int parent(int idx) {
        return items[getParentIdx(idx)];
    }

    private void swap(int idxOne, int idxTwo) {
        int temp = items[idxOne];
        items[idxOne] = items[idxTwo];
        items[idxTwo] = temp;
    }

    private void ensureCapacity() {
        if (size == maxSize) {
            items = Arrays.copyOf(items, maxSize * 2);
            maxSize *= 2;
        }
    }

    public int[] getItems() {
        return items;
    }
}