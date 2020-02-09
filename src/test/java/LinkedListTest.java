import LinkedList.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class LinkedListTest {

    @Test
    public void test() {
        LinkedList list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        assertEquals(6, list.getMiddle());
        list.append(9);
        assertEquals(7, list.getMiddle());

        list.remove(7);
        assertEquals(6, list.getMiddle());
        list.prepend(4);
        list.prepend(3);
        assertEquals(5, list.getMiddle());
    }

    @Test
    public void testReverse() {
        LinkedList list = new LinkedList();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);

        list.reverseIteratively();
        assertEquals(8, list.getHead().getData());
        assertEquals(7, list.getHead().getNext().getData());
        assertEquals(6, list.getHead().getNext().getNext().getData());
        assertEquals(5, list.getHead().getNext().getNext().getNext().getData());

        list.reverseRecursively();
        assertEquals(5, list.getHead().getData());
        assertEquals(6, list.getHead().getNext().getData());
        assertEquals(7, list.getHead().getNext().getNext().getData());
        assertEquals(8, list.getHead().getNext().getNext().getNext().getData());
    }
}
