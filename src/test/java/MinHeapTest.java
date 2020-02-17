import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import Heaps.MinHeap;
import org.junit.Test;

public class MinHeapTest {

    @Test
    public void test() {
        MinHeap minHeap = new MinHeap();
        minHeap.add(13);
        minHeap.add(6);
        minHeap.add(17);
        minHeap.add(67);
        minHeap.add(84);
        minHeap.add(35);
        minHeap.add(3);
        minHeap.add(25);
        minHeap.add(56);
        minHeap.add(43);

        assertArrayEquals(new int[]{3, 13, 6, 25, 43, 35, 17, 67, 56, 84}, minHeap.getItems());

        minHeap.add(1);
        assertArrayEquals(new int[]{1, 3, 6, 25, 13, 35, 17, 67, 56, 84, 43, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                minHeap.getItems());

        assertEquals(1, minHeap.peek());
        assertEquals(1, minHeap.poll());

        assertArrayEquals(new int[]{3, 13, 6, 25, 43, 35, 17, 67, 56, 84, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                minHeap.getItems());
    }
}
