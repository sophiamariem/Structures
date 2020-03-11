package GraphSearch;

import java.util.LinkedList;
import java.util.Stack;

public class DFSStack {

    public boolean hasPath(Node sourceNode, Node destNode) {
        Stack<Node> stack = new Stack();

        stack.push(sourceNode);
        sourceNode.isVisited = true;

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            for (Node child : node.next) {
                if (!child.isVisited) {
                    if (child == destNode) {
                        return true;
                    }
                    stack.push(child);
                    child.isVisited = true;
                }
            }
        }
        return false;
    }

    public static class Node {
        private int id;
        private LinkedList<Node> next = new LinkedList<>();
        private boolean isVisited = false;

        public Node(int id) {
            this.id = id;
        }

        public void setNext(LinkedList<Node> next) {
            this.next = next;
        }
    }
}
