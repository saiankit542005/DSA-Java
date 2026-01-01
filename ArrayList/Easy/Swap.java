package ArrayList.Easy;

import java.util.ArrayList;

public class Swap {
    // Swap two numbers
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1); // 5
        list.set(idx1, list.get(idx2)); // 3
        list.set(idx2, temp); // 5
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        int idx1 = 1, idx2 = 3;
        System.out.println("list before Swap:" + list);
        swap(list, idx1, idx2);
        System.out.println("list after Swap:" + list);

    }
}
