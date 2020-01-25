package ArrayList;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayList<E> {
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;
    private Object elements[];

    public ArrayList() {
        this.elements = new Object[DEFAULT_SIZE];
    }

    public void add(E e) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = e;
    }

    public void remove(E e) {
        OptionalInt indx;
        IntStream stream = IntStream.range(0, elements.length);
        if (e == null) {
            indx = stream
                    .filter(i -> elements[i] == null)
                    .findFirst();
        } else {
            indx = stream
                    .filter(i -> elements[i].equals(e))
                    .findFirst();
        }

        if (indx.isPresent()) {
            int index = indx.getAsInt();
            System.arraycopy(elements, index + 1, elements, index, elements.length - (index + 1)); //or set to null
            size--;
        }
    }

    public E get(int i) {
        // we don't want the null elements
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[i];
    }

    public int getLength() {
        return elements.length;
    }

    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
}
