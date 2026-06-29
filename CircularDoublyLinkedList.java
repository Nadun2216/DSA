public class CircularDoublyLinkedList {

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;
    }

    public void delete(int data) {
        if (head == null)
            return;

        Node current = head;

        do {
            if (current.data == data) {

                if (current.next == current) {
                    head = null;
                    return;
                }

                current.prev.next = current.next;
                current.next.prev = current.prev;

                if (current == head)
                    head = current.next;

                return;
            }

            current = current.next;

        } while (current != head);
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head.prev;

        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != head.prev);

        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.displayForward();
        list.displayBackward();

        list.delete(20);

        list.displayForward();
    }
}