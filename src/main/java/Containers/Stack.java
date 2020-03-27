package Containers;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private int CAPACITY = 100;
    private T[] elements;
    private int size = 0;

    public Stack() {
        elements = (T[]) new Object[CAPACITY];
    }

    public void push(T element) {
        if (size == elements.length) {
            expandSize();
        }
        elements[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // retrieve top most element
        T t = elements[--size];
        // remove it cause popped!
        elements[size] = null;
        return t;
    }

    private void expandSize() {
        int expandedSize = elements.length * 2;
        elements = Arrays.copyOf(elements, expandedSize);
    }
}
