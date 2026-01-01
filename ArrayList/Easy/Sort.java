package ArrayList.Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();

        list.add(40);
        list.add(10);
        list.add(5);
        list.add(20);
        list.add(25);
        list.add(15);
        // Collections is a class in java.util package
        System.out.println(list);
        Collections.sort(list); // accending order
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder()); // descending order
        System.out.println(list);
    }
}
