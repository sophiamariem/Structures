package GraphSearch;

import java.util.HashSet;
import java.util.LinkedList;

public class DFS {

    public boolean hasPath(Node sourceNode, Node destNode) {
        HashSet<Integer> visited = new HashSet<>();
        return hasPath(sourceNode, destNode, visited);
    }

    private boolean hasPath(Node source, Node destination, HashSet<Integer> visited) {
        if (source == destination) {
            return true;
        }

        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);

        for (Node child : source.next) {
            if (hasPath(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        protected int id;
        protected LinkedList<Node> next = new LinkedList<>();

        public Node(int id) {
            this.id = id;
        }

        public void setNext(LinkedList<Node> next) {
            this.next = next;
        }
    }

}
