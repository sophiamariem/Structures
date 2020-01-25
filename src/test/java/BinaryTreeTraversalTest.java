import BinaryTreeTraversal.BinaryTree;
import BinaryTreeTraversal.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTraversalTest {

    @Test
    public void test() {
        Node root = new Node(0);
        Node rootLeft = new Node(1);
        root.setLeft(rootLeft);
        Node rootRight = new Node(2);
        root.setRight(rootRight);
        Node leftRootLeft = new Node(3);
        rootLeft.setLeft(leftRootLeft);
        Node rightRootLeft = new Node(4);
        rootLeft.setRight(rightRootLeft);
        Node leftRootRight = new Node(5);
        rootRight.setLeft(leftRootRight);
        Node leftLeftRootLeft = new Node(6);
        leftRootLeft.setLeft(leftLeftRootLeft);
        Node leftLeftLeftRootLeft = new Node(7);
        leftLeftRootLeft.setLeft(leftLeftLeftRootLeft);

        BinaryTree binaryTree = new BinaryTree(root);

        ArrayList<Integer> inOrder =  binaryTree.inOrder();
        assertTrue(new ArrayList<>(Arrays.asList(7, 6, 3, 1, 4, 0, 5, 2)).equals(inOrder));

        ArrayList<Integer> preOrder =  binaryTree.preOrder();
        assertTrue(new ArrayList<>(Arrays.asList(0, 1, 3,6, 7, 4, 2, 5)).equals(preOrder));

        ArrayList<Integer> postOrder =  binaryTree.postOrder();
        assertTrue(new ArrayList<>(Arrays.asList(7, 6, 3, 4, 1, 5, 2, 0)).equals(postOrder));
    }
}
