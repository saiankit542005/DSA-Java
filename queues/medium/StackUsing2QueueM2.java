package queues.medium;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2QueueM2 {
        static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        //push
        public void push(int data){
            while(!q1.isEmpty()){
                q2.add(q1.remove());
            }

            q1.add(data);

            while(!q2.isEmpty()){
                q1.add(q2.remove());
            }
        }

        //pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            int top = q1.remove();
            return top;
        }

        //peek
        public int peek() {
             if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }

            int top = q1.peek();
            return top;
        }
    }

   public static void main(String[] args) {
    Stack s = new Stack();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
    }
   } 
}
