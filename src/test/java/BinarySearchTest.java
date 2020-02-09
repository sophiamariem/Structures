import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import Searching.BinarySearch;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

    private static BinarySearch binarySearch;
    private static final int[] input = new int[]{45, 67, 23, 56, 98, 76, 12, 4, 65, 43, 78, 32};

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testRecursive() {
        assertTrue(binarySearch.recursiveSearch(input, 23));
        assertFalse(binarySearch.recursiveSearch(input, 5));
    }

    @Test
    public void testIterative() {
        assertTrue(binarySearch.iterativeSearch(input, 23));
        assertFalse(binarySearch.iterativeSearch(input, 5));
    }
}
