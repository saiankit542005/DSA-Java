package ArrayList.Medium;

import java.util.ArrayList;

//This code is using brute force , TC = O(n^2)
public class MaxWater1 {
    static int maxWater = 0;

    public static int storeWater(ArrayList<Integer> height) {
        // Function ArrayList<Integer> type ka parameter expect karta hai
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int minHeight = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int currWater = minHeight * width;

                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));
        // Ham yha value pass nhi kr rhe , ArrayList ka reference pass kr rhe ho
        // java compiler internally ye smjta hai: = >
        // ArrayList<Integer> height = (ArrayList<Integer>) height;
        // Type match ho rha hai, so koi error nhi.

    }
}
