
public class StudentLL {
    public static class Node {
        int studentId;
        String name;
        Node next;

        public Node(int studentId, String name) {
            this.studentId = studentId;
            this.name = name;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // add First method
    public void addFirst(int studentId, String name) {
        // create new Node
        Node newNode = new Node(studentId, name);

        // check if list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print("{"+temp.studentId + "," + temp.name + "}"+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        StudentLL ll = new StudentLL();
        ll.addFirst(1, "ankit");
        ll.addFirst(2, "sachin");
        ll.addFirst(3, "golu");
        ll.addFirst(4, "kapil");
        ll.printLL();
    }
}
