public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        System.out.println("Enqueued: " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        int value = queue[front];
        front = (front + 1) % capacity;
        size--;

        System.out.println("Dequeued: " + value);
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void display() {
        System.out.print("Queue: ");

        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("=== Array Circular Queue ===\n");

        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        System.out.println("Front element: " + queue.peek());

        queue.dequeue();
        queue.dequeue();

        queue.display();

        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();

        System.out.println("Queue size: " + queue.size());
    }
}