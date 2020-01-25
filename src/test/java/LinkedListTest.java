import LinkedList.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
