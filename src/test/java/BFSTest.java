import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

import GraphSearch.BFS;

public class BFSTest {

    @Test
    public void test() {
        BFS bfs = new BFS();

        BFS.Node source = new BFS.Node(5);
        BFS.Node destination = new BFS.Node(11);

        BFS.Node next = new BFS.Node(8);
        BFS.Node another = new BFS.Node(45);

        source.setNext(new LinkedList<>(Arrays.asList(next, another)));
        assertFalse(bfs.hasPath(source, destination));

        source.setNext(new LinkedList<>(Arrays.asList(next, another, destination)));
        assertTrue(bfs.hasPath(source, destination));
    }
}
