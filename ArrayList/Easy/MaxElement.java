package ArrayList.Easy;

import java.util.ArrayList;

public class MaxElement {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(5);
        list.add(20);
        list.add(50);
        list.add(25);

        int max = 0; // negative numbers ho to galat result
        // int max = Integer.MIN_VALUE; // max = - infinity (intialize) 
        // number)
        for (int i = 0; i < list.size(); i++) {
            // if (max < list.get(i)) {
            // max = list.get(i);
            // }
            max = Math.max(max, list.get(i)); // second way
        }
        System.out.println("Maximum Element of list1 : " + max);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(-10);
        list2.add(-30);
        list2.add(-5);
        list2.add(-20);
        list2.add(-50);
        list2.add(-25);

        // int maximum = 0; // yah 0 output dega jo ki wrong hai => output = -5 hoga
        int maximum = Integer.MIN_VALUE; //(Sahi ✅:for all numbers)
        for (int i = 0; i < list2.size(); i++) {
            if (maximum < list2.get(i)) {
                maximum = list2.get(i);
            }
        }
        System.out.println("Maximum Element of list2 : " + maximum);
    }
}