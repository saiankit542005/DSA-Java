package stack.medium;

import java.util.Stack;

public class PushAtBottom {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) { // Base case
            s.push(data);
            return;
        }
        int top = s.pop(); // remove element from stack
        pushAtBottom(s, data);//recursion call
        s.push(top); // add  < - Backtracking 
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
