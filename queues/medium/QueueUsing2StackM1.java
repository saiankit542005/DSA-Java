package queues.medium;

import java.util.Stack;

public class QueueUsing2StackM1 {
     //Remove & Peek() -- TC = (1)
    //add -- TC = O(n)
    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // add - O(n)
        public void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove - O(1)
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = s1.pop();
            return front;
        }

        // peek - O(1)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}

/*
 * 
 * 🔹 Concept first (Queue vs Stack) :=======>
 * 
 * Queue → FIFO (First In First Out)
 * Example: 1, 2, 3 → remove gives 1
 * 
 * Stack → LIFO (Last In First Out)
 * Example: 1, 2, 3 → pop gives 3
 * 
 * 👉 To make a Queue using Stacks, we use two stacks (s1 and s2) and some
 * clever shifting.
 * 
 * 🔹 Data Structures Used :=======>
 * Stack<Integer> s1 = new Stack<>();
 * Stack<Integer> s2 = new Stack<>();
 * 
 * s1 → always keeps elements in queue order
 * 
 * s2 → helper stack (temporary use)
 * 
 * 🔹 isEmpty() :=======>
 * public boolean isEmpty() {
 * return s1.isEmpty();
 * }
 * 
 * ✔️ If s1 is empty → Queue is empty.
 * 
 * 🔹 add(int data) ➜ ENQUEUE :=======>
 * Code:
 * public void add(int data) {
 * while (!s1.isEmpty()) {
 * s2.push(s1.pop());
 * }
 * 
 * s1.push(data);
 * 
 * while (!s2.isEmpty()) {
 * s1.push(s2.pop());
 * }
 * }
 * 
 * 🔍 Working (Example) :=======>
 * Let’s add 1, 2, 3
 * 
 * ➤ add(1)
 * s1 = []
 * s2 = []
 * Push 1 to s1
 * 👉 s1 = [1]
 * 
 * ➤ add(2)
 * 1️⃣ Move all elements from s1 → s2
 * s1 = []
 * s2 = [1]
 * 
 * 2️⃣ Push new element into s1
 * s1 = [2]
 * 
 * 3️⃣ Move back from s2 → s1
 * s1 = [2, 1]
 * 
 * ➤ add(3)
 * 1️⃣ Move s1 → s2
 * s2 = [1, 2]
 * 
 * 2️⃣ Push 3 into s1
 * s1 = [3]
 * 
 * 3️⃣ Move back s2 → s1
 * s1 = [3, 2, 1]
 * 
 * ✅ Final stack order
 * Top → 1
 * 2
 * 3
 * Bottom
 * 
 * 
 * So front of queue is always on top of s1 ✔️
 * 
 * 🔹 remove() ➜ DEQUEUE
 * public int remove() {
 * if(isEmpty()){
 * System.out.println("Queue is empty");
 * return -1;
 * }
 * return s1.pop();
 * }
 * 
 * 
 * Simply pop from s1
 * 
 * Because front element is already on top
 * 
 * Example :=======>
 * 
 * s1 = [3, 2, 1]
 * remove() → 1
 * 
 * 🔹 peek() ➜ FRONT ELEMENT
 * public int peek() {
 * if(isEmpty()){
 * System.out.println("Queue is empty");
 * return -1;
 * }
 * return s1.peek();
 * }
 * 
 * 
 * Returns front element without removing it
 * 
 * 🔹 main() Execution
 * q.add(1);
 * q.add(2);
 * q.add(3);
 * 
 * 
 * Queue becomes:
 * 
 * Front → 1 2 3 ← Rear
 * 
 * 
 * Loop:
 * 
 * while(!q.isEmpty()){
 * System.out.println(q.peek());
 * q.remove();
 * }
 * 
 * Output:
 * 1
 * 2
 * 3
 * 
 * 🔹 Time Complexity :=======>
 * Operation ==>Time
 * add ===>O(n)
 * remove==> O(1)
 * peek ==> O(1)
 * 
 * 👉 This is called “Costly Enqueue” Queue using Stacks
 * 
 * If you want, I can also explain:
 * ✅ Costly Dequeue approach
 * ✅ Dry run using diagram
 * ✅ Interview explanation in 2 lines
 * 
 */
