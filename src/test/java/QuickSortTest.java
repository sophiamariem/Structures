import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import Sorting.QuickSort;

public class QuickSortTest {

    @Test
    public void test() {
        QuickSort quick = new QuickSort();
        assertArrayEquals(quick.quicksort(new int[]{34, 2, 21, 7, 9, 12, 50}), new int[] {2, 7, 9, 12, 21, 34, 50});
    }
}
