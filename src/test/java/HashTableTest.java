import HashTable.HashTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTest {

    @Test
    public void test() {
        HashTable tbl = new HashTable();
        tbl.put("a", "b");
        tbl.put("c", "d");
        tbl.put("e", "f");
        tbl.put("g", "h");
        tbl.put("a", "b");
        tbl.put("a", "b");
        tbl.put("c", "e");
        assertEquals(4, tbl.getNonNullEntryCount());
        assertEquals("d", tbl.get("c"));

        assertEquals("e", tbl.getEntry("c").getNext().getValue());

        tbl.remove("c");
        assertNull(tbl.getEntry("c").getNext());

        tbl.remove("c");
        assertEquals(3, tbl.getNonNullEntryCount());
        assertNull(tbl.get("c"));
    }
}
