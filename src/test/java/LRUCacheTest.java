import static org.junit.Assert.assertEquals;

import Cache.LRUCache;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(5);

        cache.setKeyValue(1, "1");
        assertEquals(1, cache.getMap().size());

        cache.setKeyValue(2, "2");
        assertEquals(2, cache.getMap().size());
        assertEquals("2", cache.getListHead().getValue());

        cache.setKeyValue(3, "3");
        assertEquals(3, cache.getMap().size());
        assertEquals("3", cache.getListHead().getValue());

        cache.getValue(1);
        assertEquals("1", cache.getListHead().getValue());

        cache.setKeyValue(4, "4");
        assertEquals(4, cache.getMap().size());
        assertEquals("4", cache.getListHead().getValue());

        cache.getValue(2);
        assertEquals("2", cache.getListHead().getValue());

        cache.setKeyValue(5, "5");
        assertEquals(5, cache.getMap().size());
        assertEquals("5", cache.getListHead().getValue());
        assertEquals("3", cache.getListTail().getValue());

        cache.getValue(5);
        assertEquals("5", cache.getListHead().getValue());

        cache.setKeyValue(6, "6");
        assertEquals("6", cache.getListHead().getValue());

        assertEquals(5, cache.getMap().size());
        assertEquals("6", cache.getListHead().getValue());
        assertEquals("1", cache.getListTail().getValue());

        cache.getValue(1);
        assertEquals("1", cache.getListHead().getValue());
        assertEquals("4", cache.getListTail().getValue());

        cache.setKeyValue(5, "5a");
        assertEquals(5, cache.getMap().size());
        assertEquals("5a", cache.getListHead().getValue());

        cache.getValue(3);
        assertEquals("5a", cache.getListHead().getValue());
        assertEquals(5, cache.getMap().size());
    }
}
