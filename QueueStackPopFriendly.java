import java.util.*;

public class QueueStackPopFriendly {

    Queue<Integer> q = new LinkedList<>();

    public void push(int x) {
        q.add(x);

        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return q.remove();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly s = new QueueStackPopFriendly();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}