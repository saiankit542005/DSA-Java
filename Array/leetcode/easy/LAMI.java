package Array.leetcode.easy;

public class LAMI {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= n - k; j++) {

                for (int l = j; l < j + k; l++) {
                    if (nums[i] == nums[l]) {
                        count++;
                        break;
                    }
                }
            }
            if (max < nums[i] && count == 1) {
                max = nums[i];
            }
            count = 0;
        }

        if (max == Integer.MIN_VALUE) {
            return -1;
        }
        return max;
    }

    public static void main(String[] args) {
        LAMI obj = new LAMI();
        int nums[] = { -5, -2, -3 };
        int k = 3;
        System.out.println(obj.largestInteger(nums, k));
    }
}