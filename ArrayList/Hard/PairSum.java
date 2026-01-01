package ArrayList.Hard;

import java.util.ArrayList;

public class PairSum {
    public static boolean twoPairSum(ArrayList<Integer> list, int target) {
        int bp = 0; // breaking point
        int n = list.size();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }
        int lp = bp + 1;
        int rp = bp;
        int sum = 0;
        while (lp != rp) {
            // case 1
            sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                System.out.println(list.get(lp) + " " + list.get(rp));
                return true;
            }
            // case 2
            if (sum < target) {
                lp = (lp + 1) % n;
            // Case 3
            } else {
                rp = (n + rp - 1) % n;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(twoPairSum(list, target));
    }
}
