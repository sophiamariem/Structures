package Trees;

public class BSTNode {
    private BSTNode left;
    private BSTNode right;
    private int data;

    public BSTNode(int data) {
        this.data = data;
    }

    public void insert(int val) {
        if (val <= data) {
            if (left == null) {
                left = new BSTNode(val);
            } else {
                left.insert(val);
            }
        } else {
            if (right == null) {
                right = new BSTNode(val);
            } else {
                right.insert(val);
            }
        }
    }

    public boolean contains(int val) {
        if (val == data) {
            return true;
        } else if (val < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(val);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(val);
            }
        }
    }

    public void inOrder() {
        if (left != null) {
            left.inOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.inOrder();
        }
    }
}
