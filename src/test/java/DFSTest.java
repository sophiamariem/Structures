import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;

import GraphSearch.DFS;
import org.junit.Test;

public class DFSTest {

    @Test
    public void test() {
        DFS dfs = new DFS();

        DFS.Node source = new DFS.Node(5);
        DFS.Node destination = new DFS.Node(11);

        DFS.Node next = new DFS.Node(8);
        DFS.Node another = new DFS.Node(45);

        source.setNext(new LinkedList<>(Arrays.asList(next, another)));
        assertFalse(dfs.hasPath(source, destination));

        source.setNext(new LinkedList<>(Arrays.asList(next, another, destination)));
        assertTrue(dfs.hasPath(source, destination));
    }
}
