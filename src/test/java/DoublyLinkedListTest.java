import DoublyLinkedList.DoublyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoublyLinkedListTest {

    @Test
    public void test() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);

        assertEquals(-1, list.getPrevious(5));
        assertEquals(5, list.getPrevious(6));
        assertEquals(6, list.getPrevious(7));
        assertEquals(7, list.getPrevious(8));
        assertEquals(8, list.getPrevious(9));

        list.remove(7);
        assertEquals(6, list.getPrevious(8));

        list.prepend(4);
        assertEquals(4, list.getPrevious(5));
        assertEquals(-1, list.getPrevious(4));
    }

    @Test
    public void testReverse() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);

        list.reverseIteratively();
        assertEquals(8, list.getHead().getData());
        assertNull(list.getHead().getPrevious());

        assertEquals(7, list.getHead().getNext().getData());
        assertEquals(8, list.getHead().getNext().getPrevious().getData());

        assertEquals(6, list.getHead().getNext().getNext().getData());
        assertEquals(7, list.getHead().getNext().getNext().getPrevious().getData());

        assertEquals(5, list.getHead().getNext().getNext().getNext().getData());
        assertEquals(6, list.getHead().getNext().getNext().getNext().getPrevious().getData());

        list.reverseRecursively();
        assertEquals(5, list.getHead().getData());
        assertNull(list.getHead().getPrevious());

        assertEquals(6, list.getHead().getNext().getData());
        assertEquals(5, list.getHead().getNext().getPrevious().getData());

        assertEquals(7, list.getHead().getNext().getNext().getData());
        assertEquals(6, list.getHead().getNext().getNext().getPrevious().getData());

        assertEquals(8, list.getHead().getNext().getNext().getNext().getData());
        assertEquals(7, list.getHead().getNext().getNext().getNext().getPrevious().getData());
    }
}
