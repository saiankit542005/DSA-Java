package stack;

public class StackUsingLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class Stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        // push method
        public static void push(int data) {
            // create a new Node
            Node newNode = new Node(data);

            // if statck is empty
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        // pop method
        public static int pop() {
            // if statck is empty
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }

            return head.data;// top of stack
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
