public class DoublyLinkedList {

    class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head;

    public void insert(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
            newNode.prev = current;
        }

        System.out.println("Inserted: " + value);
    }

    public void delete(int value) {

        Node current = head;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }

        System.out.println("Deleted: " + value);
    }

    public void displayForward() {

        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        System.out.println("=== Doubly Linked List ===\n");

        DoublyLinkedList list = new DoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.displayForward();

        list.delete(20);

        list.displayForward();
    }
}