package LinkedList;

public class LinkedList {
    private Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.setNext(this.head);
        this.head = newHead;
    }

    public void remove(int data) {
        Node current = this.head;
        if (current == null) {
            return;
        }
        if (current.getData() == data) {
            this.head = current.getNext();
        }
        while (current.getNext() != null) {
            if (current.getNext().getData() == data) {
                current.setNext(current.getNext().getNext());
            }
            current = current.getNext();
        }
    }

    // One pointer will advance 2 nodes in each iteration and the other pointer will advance only one node per iteration.
    // When the faster pointer reaches the end of the list, the slower pointer will be in the middle:
    public int getMiddle() {
        if (this.head == null) {
            return -1;
        }

        Node slowPointer = this.head;
        Node fastPointer = this.head;
        while (fastPointer.getNext() != null && fastPointer.getNext().getNext() != null) {
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }

        return slowPointer.getData();
    }

    public void reverseIteratively() {
        Node current = head;
        Node previous = null;
        Node next;

        while (current != null) {
            next = current.getNext(); // stash
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void reverseRecursively() {
        head = reverseRec(head);
    }

    public Node reverseRec(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }

        Node reverse = reverseRec(node.getNext());
        node.getNext().setNext(node); // next node to now have me as next (reversed)
        node.setNext(null); // delete previous link, otherwise loop
        return reverse;
    }

    public Node getHead() {
        return head;
    }
}
