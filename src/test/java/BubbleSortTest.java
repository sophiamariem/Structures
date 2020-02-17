import static org.junit.Assert.assertArrayEquals;

import Sorting.BubbleSort;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void test() {
        BubbleSort bubble = new BubbleSort();
        assertArrayEquals(bubble.bubbleSort(new int[]{34, 2, 21, 7, 9, 12, 50}), new int[] {2, 7, 9, 12, 21, 34, 50});
    }
}