import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import GraphSearch.DFSStack;

public class DFSStackTest {

        @Test
        public void test() {
            DFSStack dfs = new DFSStack();

            DFSStack.Node source = new DFSStack.Node(5);
            DFSStack.Node destination = new DFSStack.Node(11);

            DFSStack.Node next = new DFSStack.Node(8);
            DFSStack.Node another = new DFSStack.Node(45);

            source.setNext(new LinkedList<>(Arrays.asList(next, another)));
            assertFalse(dfs.hasPath(source, destination));

            source.setNext(new LinkedList<>(Arrays.asList(next, another, destination)));
            assertTrue(dfs.hasPath(source, destination));
        }
}
