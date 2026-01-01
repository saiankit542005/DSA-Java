package ArrayList.Medium;

import java.util.ArrayList;

public class MaxWater2 {
    //Using 2 Pointer Approach - > TC = O(n)
    static int maxWater = 0;

    public static int storeWater(ArrayList<Integer> height) {
        int lp = 0;
        int rp = height.size() - 1;
        //Calculate water area
        while (lp < rp) {
            int minHeight = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = minHeight*width;
            maxWater = Math.max(maxWater, currWater);
            System.out.println("Current Water : " +currWater);
        //Update pointer
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
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

        System.out.println("Max Water : "+storeWater(height));
    }
}
