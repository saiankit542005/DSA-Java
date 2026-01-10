
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
    public static int size;

    public void addFirst(int data) { // TC = O(1)
        // step 1 = create new Node
        Node newNode = new Node(data);
        size++;
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
        size++;
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

    public void addMiddle(int data, int idx) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // Now, i = idx - 1 ,temp = idx se phle wala (previous)
        // 1 first
        newNode.next = temp.next;
        // 2.secons
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // or tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int removeMiddle(int idx) {

        // case 1: empty list
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        // case 2:  // invalid index
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }

        // case 3: first node
        if (idx == 0) {
            return removeFirst();
        }

        // case 4: last node
        if (idx == size - 1) {
            return removeLast();
        }

        // case 5: middle node
        Node prev = head;
        for (int i = 0; i < idx - 1; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // node to be deleted
        prev.next = prev.next.next; // link bypass
        size--;

        return val;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.printLL();
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addLast(30);
        ll.addLast(40);
        ll.addMiddle(25, 2);
        ll.printLL();
        System.out.println("Remove First Node data : " + ll.removeFirst());
        ll.printLL();
        System.out.println("Remove Last Node data : " + ll.removeLast());
        ll.printLL();
       System.out.println("Remove Middle Node data : "+ ll.removeMiddle(1));
        ll.printLL();
        System.out.println("Size of Linked List : " + size);
    }
}