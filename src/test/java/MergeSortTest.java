import static org.junit.Assert.assertArrayEquals;

import Sorting.MergeSort;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void test() {
        MergeSort merge = new MergeSort();
        assertArrayEquals(merge.mergeSort(new int[]{34, 2, 21, 7, 9, 12, 50}), new int[] {2, 7, 9, 12, 21, 34, 50});
    }
}
