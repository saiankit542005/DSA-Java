package stack;

import java.util.Stack;

// ✅ Java Collection Framework in Stack:===>
public class JavaCollFramework {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

         // peek -> it only return top element
        System.out.println("Top: " + s.peek());

        // pop -> it pop then return popped element
        System.out.println("Removed: " + s.pop());

        // isEmpty -> check stack is empty or not
        System.out.println("Empty? " + s.isEmpty());

        while(!s.isEmpty()){
            System.out.println(s.pop());
            // s.pop();
        }
    }  
}
