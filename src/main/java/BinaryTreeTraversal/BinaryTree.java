package BinaryTreeTraversal;


import java.util.ArrayList;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public ArrayList<Integer> inOrder() {
        ArrayList<Integer> nodes = new ArrayList<>();
        return inOrder(nodes, root);
    }

    private ArrayList<Integer> inOrder(ArrayList<Integer> nodes, Node node) {
        if (node == null) {
            return nodes;
        }

        inOrder(nodes, node.getLeft());
        nodes.add(node.getKey());
        inOrder(nodes, node.getRight());
        return nodes;
    }

    public ArrayList<Integer> preOrder() {
        ArrayList<Integer> nodes = new ArrayList<>();
        return preOrder(nodes, root);
    }

    private ArrayList<Integer> preOrder(ArrayList<Integer> nodes, Node node) {
        if (node == null) {
            return nodes;
        }

        nodes.add(node.getKey());
        preOrder(nodes, node.getLeft());
        preOrder(nodes, node.getRight());
        return nodes;
    }

    public ArrayList<Integer> postOrder() {
        ArrayList<Integer> nodes = new ArrayList<>();
        return postOrder(nodes, root);
    }

    private ArrayList<Integer> postOrder(ArrayList<Integer> nodes, Node node) {
        if (node == null) {
            return nodes;
        }

        postOrder(nodes, node.getLeft());
        postOrder(nodes, node.getRight());
        nodes.add(node.getKey());
        return nodes;
    }

}
