package DoubleLL;

public class DoubleLL {
    public class Node {
        int data;
        Node next;// next pointer
        Node prev;// previous pointer

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // ================= add first ==================
    public void addFirst(int data) {
        // create new node
        Node newNode = new Node(data);
        size++;

        // if LinkedList is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // ================= remove first ==================
    public int removeFirst() {
        // if LL is empty
        if (head == null) {
            System.out.println("DoubleLL is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // ================= print DoubleLL ==================
    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" <--> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(6);
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.printLL();

        System.out.println("Size of DoubleLL : " + size);
    }
}
