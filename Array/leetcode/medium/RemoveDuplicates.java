package Array.leetcode.medium;

import java.util.Scanner;

/**
 * 
 * 1209. Remove All Adjacent Duplicates in String II
 * 
 * Leve : Medium
 * 
 * Time Complexity : O(n³)
 * Space Complexity : O(n)
 * 
 * Outer loop → O(n)
 * Inner loop → O(n)
 * Deletion (StringBuilder.delete) → O(n)
 * 
 * 👉 Combined:
 * O(n) × O(n) × O(n) = O(n^3)
 */

public class RemoveDuplicates {
    public String removeDuplicates(String s, int k) {

        // Convert string to StringBuilder for easy deletion
        StringBuilder answer = new StringBuilder(s);

        // Traverse the string
        for (int i = 0; i < answer.length(); i++) {

            // Count of consecutive same characters (current char included)
            int count = 1;

            // Check next characters for duplicates
            for (int j = i + 1; j < answer.length(); j++) {

                // If characters are different, stop counting
                if (answer.charAt(i) != answer.charAt(j)) {
                    break;
                }

                // Same character found → increase count
                count++;

                // If count reaches k → remove substring
                if (count == k) {

                    // Delete from index i to j (inclusive)
                    answer.delete(i, j + 1);

                    // Move index back to handle chain reaction
                    // Example: after deletion, new duplicates may form
                    i = Math.max(-1, i - k);

                    // Break inner loop and continue scanning
                    break;
                }
            }
        }
        // Return final processed string
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        // Input k
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // Create object of Solution
        RemoveDuplicates obj = new RemoveDuplicates();

        // Call method
        String result = obj.removeDuplicates(s, k);

        // Output
        System.out.println("Final string: " + result);

        sc.close();
    }
}