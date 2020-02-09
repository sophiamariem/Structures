package GraphSearch;

import java.util.HashSet;
import java.util.LinkedList;

public class BFS {

    public boolean hasPath(Node sourceNode, Node destNode) {
        LinkedList<Node> next = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        next.add(sourceNode);

        while (!next.isEmpty()) {
            Node node = next.remove();
            if (node == destNode) {
                return true;
            }

            if (!visited.contains(node.id)) {
                visited.add(node.id);
                for (Node child : node.next) {
                    next.add(child);
                }
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
