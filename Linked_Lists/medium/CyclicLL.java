package medium;

public class CyclicLL {
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

    public static boolean isCyclic(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if(slow == fast){
                return true;
            }
        }
       return false;
    }

    public static void main(String[] args) {
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);
        Node v5 = new Node(5);

        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;
        v5.next = v1; // 5.next -> 20
     //1 -> 2 -> 3 -> 4 -> 5 -> 1
        head = v1;
        //if cycle exist then return true otherwise  return false
        System.out.println(isCyclic());
    }
}
