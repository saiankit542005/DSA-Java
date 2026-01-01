package ArrayList.Medium;

import java.util.ArrayList;

public class PairSum2 {
// 2 Pointer Approach :=> TC -> O(n)
    public static boolean checkPair(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;

        while (lp < rp) {
            int sum = list.get(lp) + list.get(rp);

            if (sum == target) {
                System.out.println("first Solution:"+list.get(lp) + "+" + list.get(rp)+" = "+sum);
                return true;
            } 
            if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(i); // 1 2 3 4 5 6
        }
        int target = 5;
        System.out.println(checkPair(list, target));
    }
}

