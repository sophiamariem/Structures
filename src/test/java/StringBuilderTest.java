import static org.junit.Assert.assertEquals;

import StringBuilder.StringBuilder;
import org.junit.Test;

public class StringBuilderTest {

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(" world");
        sb.append(" how is it going");
        assertEquals("hello world how is it going", sb.toString());

        sb.insert(11, "!");
        assertEquals("hello world! how is it going", sb.toString());

        sb.insert(6, "beautiful ");
        assertEquals("hello beautiful world! how is it going", sb.toString());
    }

}
