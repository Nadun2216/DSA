public class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
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
        }

        System.out.println("Inserted: " + value);
    }

    public void delete(int value) {

        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println("Deleted: " + value);
            return;
        }

        Node current = head;

        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Deleted: " + value);
        }
    }

    public void display() {

        Node current = head;

        System.out.print("List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        System.out.println("=== Singly Linked List ===\n");

        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.display();

        list.delete(20);

        list.display();
    }
}