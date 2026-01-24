package medium;

public class RemoveCycle {
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

    public static boolean isCyclic() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // cyclic exist
            }
        }
        return false; // cyclic doesn't exist
    }

    public static void removeCycle() {
        // jab cycle ka last node head se connet ho => 1->2->3->1
        // fir yah code error dega , otherwise work krega.
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                cycle = true;
                break; // jab meeting point milta hai.
            }
        }
        if (cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle => prev.next = null;
        prev.next = null;
    }

    public static void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n2;
        // 1->2->3->4->5->6->3

        head = n1;

        System.out.println("Cycle exist then return true : "+isCyclic());
        removeCycle();
        System.out.println("Cyclic removed then retuen false : "+isCyclic());
        printLL(head);
    }
}