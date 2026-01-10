package Linked_Lists;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) { // TC = O(1)
        // step 1 = create new Node
        Node newNode = new Node(data);
        // step 2 = check list is empty or not.
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 3 = newNode ka next -> head
        newNode.next = head; // link

        // step 4 = head = newNode
        head = newNode;
    }

    public void addLast(int data) { // TC = O(1)
        // step 1 = create new Node
        Node newNode = new Node(data);

        // step 2 = check list is empty or not.
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 3 = tail ka next -> newNode
        tail.next = newNode;

        // step 4 = Tail ko update karo.
        tail = newNode;
    }

    public void printLL() { // TC = O(n)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.printLL();
        ll.addFirst(20);
        ll.printLL();
        ll.addFirst(10);
        ll.printLL();
        ll.addLast(30);
        ll.printLL();
        ll.addLast(40);
        ll.printLL();
    }
}