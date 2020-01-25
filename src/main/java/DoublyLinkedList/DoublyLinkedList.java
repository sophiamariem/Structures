package DoublyLinkedList;

public class DoublyLinkedList {
    private DoublyNode head;

    public void append(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        DoublyNode current = this.head;

        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        current.getNext().setPrevious(current);
    }

    public void prepend(int data) {
        DoublyNode newHead = new DoublyNode(data);

        if (this.head != null) {
            this.head.setPrevious(newHead);
        }

        newHead.setNext(this.head);
        this.head = newHead;
    }

    public void remove(int data) {
        DoublyNode current = this.head;
        if (current == null) {
            return;
        }
        if (current.getData() == data) {
            this.head = current.getNext();
        }

        while (current.getNext() != null) {
            if (current.getNext().getData() == data) {
                current.setNext(current.getNext().getNext());
                current.getNext().setPrevious(current);
            }
            current = current.getNext();
        }
    }

    public int getPrevious(int data) {
        DoublyNode current = this.head;
        while (current != null) {
            if (current.getData() == data) {
                if (current.getPrevious() != null) {
                    return current.getPrevious().getData();
                }
                return -1;
            }
            current = current.getNext();
        }
        return -1;
    }
}
