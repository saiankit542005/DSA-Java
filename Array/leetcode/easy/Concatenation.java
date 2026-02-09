package Array.leetcode.easy;

public class Concatenation {
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;

        int ans[] = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            ans[n + i] = nums[i];
        }

        return ans;
    }

    public static void printArr(int ans[]) {
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1 };

        System.out.println("Input :");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        System.out.println("Output : ");
        int ans[] = getConcatenation(nums);
        printArr(ans);
    }
}
