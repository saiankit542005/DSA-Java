package Array.leetcode.easy;

import java.util.Scanner;

/**
 * 496. Next Greater Element I
 * Level : Easy
 * Time Complexity : O(n × m)
 * Space Complexity : O(1)
 */

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // Result array to store answers for each element of nums1
        int ans[] = new int[nums1.length];

        // Loop through each element of nums1
        for (int i = 0; i < nums1.length; i++) {

            // Find the position of nums1[i] inside nums2
            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    // Assume no greater element exists (default = -1)
                    ans[i] = -1;

                    // Traverse the right side of nums2 (j+1 onwards)
                    for (int k = j + 1; k < nums2.length; k++) {

                        // If we find a greater element
                        if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k]; // update answer
                            break; // stop after first greater element
                        }
                    }
                    // Since elements are unique, no need to search further in nums2
                    break;
                }
            }
        }
        // Return final result array
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input : ");
        System.out.println(" ==== nums1 is a subset of num2 ====");
        System.out.print("Enter num1: ");
        int n = sc.nextInt();
        int nums1[] = new int[n];

        System.out.println("Enter num1 elements : ");
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter nums2 : ");
        int m = sc.nextInt();
        int nums2[] = new int[m];

        System.out.println("Enter num2 elements : ");
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        NextGreaterElement obj = new NextGreaterElement();

        int ans[] = obj.nextGreaterElement(nums1, nums2);

        System.out.println("Output : ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}