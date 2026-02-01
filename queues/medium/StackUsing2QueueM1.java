package queues.medium;

import java.util.Queue;
import java.util.LinkedList;

public class StackUsing2QueueM1 {

    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // push - O(1)
        public void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // pop - O(n)
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = -1;
            // case1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            }
            // case2
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // peek - O(n)
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = -1;

            // case1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            }
            // case2
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}

/**
 * 
 * Ab is Stack using 2 Queues ke working ko step-by-step dry run ke saath
 * samjhte hain.
 * (Ye push O(1), pop/peek O(n) wala approach hai.)
 * 
 * 🔹 Core Idea (yaad rakhne wali baat)
 * 
 * Stack → LIFO (Last In First Out)
 * Queue → FIFO (First In First Out)
 * 
 * 👉 Trick:
 * push() → simple (sirf ek queue me add)
 * 
 * pop()/peek() → last element nikaalne ke liye baaki sab elements dusri queue
 * me shift
 * 
 * Rule:
 * Hamesha ek hi queue active hoti hai (q1 ya q2)
 * 
 * 🔹 Initial State
 * q1 = []
 * q2 = []
 * 
 * 🔹 push(1)
 * if (!q1.isEmpty()) // false
 * else q2.add(1);
 * 
 * q1 = []
 * q2 = [1]
 * 
 * 🔹 push(2)
 * q1 empty → else
 * 
 * q2 = [1, 2]
 * 
 * 🔹 push(3)
 * q2 = [1, 2, 3]
 * 
 * 🔹 peek() (first time)
 * 
 * Active queue = q2
 * 
 * while (!q2.isEmpty()) {
 * top = q2.remove();
 * q1.add(top);
 * }
 * 
 * 
 * Step-by-step:
 * remove 1 → q1 = [1]
 * remove 2 → q1 = [1, 2]
 * remove 3 → q1 = [1, 2, 3]
 * 
 * 
 * top = 3
 * 
 * return 3
 * 
 * State after peek:
 * q1 = [1, 2, 3]
 * q2 = []
 * 
 * Printed: 3
 * 
 * 🔹 pop() (first time)
 * 
 * Active queue = q1
 * 
 * while (!q1.isEmpty()) {
 * top = q1.remove();
 * if (q1.isEmpty()) break;
 * q2.add(top);
 * }
 * 
 * Steps:
 * remove 1 → q2 = [1]
 * remove 2 → q2 = [1, 2]
 * remove 3 → stop (last element)
 * 
 * popped element = 3
 * 
 * State:
 * q1 = []
 * q2 = [1, 2]
 * 
 * 🔹 peek() (second time)
 * 
 * Active queue = q2
 * 
 * Transfer all to q1:
 * q1 = [1, 2]
 * q2 = []
 * top = 2
 * 
 * Printed:2
 * 
 * 🔹 pop() (second time)
 * q2 = [1]
 * popped = 2
 * 
 * 🔹 peek() (third time)
 * top = 1
 * 
 * Printed:1
 * 
 * 🔹 pop() (third time)
 * q1 = []
 * q2 = []
 * 
 * 🔹 Final Output
 * 3
 * 2
 * 1
 * 
 * ✔️ Correct LIFO order
 * ⏱️ Time Complexity
 * Operation TC
 * push O(1)
 * pop O(n)
 * peek O(n)
 * isEmpty O(1)
 * 
 * 🎯 Interview One-Line Explanation :========>
 * Push is O(1) because we insert into the active queue.
 * For pop/peek, we move n−1 elements to the other queue to access the last
 * element, making it O(n).
 * 
 */