import ArrayList.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ArrayListTest {

    @Test
    public void test() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("r");
        }

        assertEquals(10, list.getLength());

        list.add("4");
        assertEquals(20, list.getLength());

        assertEquals("4", list.get(10));

        list.remove("4");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(10);
        });
        assertEquals(20, list.getLength());
    }

}
