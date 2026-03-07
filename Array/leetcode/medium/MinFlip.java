package Array.leetcode.medium;

import java.util.Scanner;

/**
 * Q.1888 Minimum Number of Flips to Make the Binary String Alternating
 *
 * Difficulty: Medium
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Approach:
 * - Use sliding window.
 * - Create two alternating patterns (0101... and 1010...).
 * - Compare window with both patterns and count flips.
 * - Take minimum flips.
 */

public class MinFlip {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            s1.append((i % 2 == 0) ? '0' : '1');
            s2.append((i % 2 == 0) ? '1' : '0');
        }

        int result = Integer.MAX_VALUE;
        int flip1 = 0, flip2 = 0;

        int i = 0;

        for (int j = 0; j < 2 * n; j++) {

            if (s.charAt(j) != s1.charAt(j))
                flip1++;
            if (s.charAt(j) != s2.charAt(j))
                flip2++;

            if (j - i + 1 > n) {
                if (s.charAt(i) != s1.charAt(i))
                    flip1--;
                if (s.charAt(i) != s2.charAt(i))
                    flip2--;
                i++;
            }

            if (j - i + 1 == n) {
                result = Math.min(result, Math.min(flip1, flip2));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinFlip obj = new MinFlip();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String (0/1) : ");
        String s = sc.nextLine();

        if (!s.matches("[01]+")) {
            System.out.println("Error: Please enter only 0 and 1.");
        } else {
            System.out.println("Output: " + obj.minFlips(s));
        }

        sc.close();
    }
}
