import static org.junit.Assert.*;

import Trees.BSTNode;
import org.junit.Test;

public class BSTNodeTest {

    @Test
    public void test() {
        BSTNode node = new BSTNode(10);
        node.insert(8);
        node.insert(12);
        node.insert(5);
        node.insert(14);

        assertTrue(node.contains(8));
        assertFalse(node.contains(1));

        node.inOrder(); // 5 8 10 12 14
    }
}
