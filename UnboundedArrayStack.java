public class UnboundedArrayStack {

    int[] arr = new int[2];
    int top = -1;

    public void push(int x) {
        if (top == arr.length - 1) {
            int[] newArr = new int[arr.length * 2];

            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }

        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        return arr[top--];
    }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}