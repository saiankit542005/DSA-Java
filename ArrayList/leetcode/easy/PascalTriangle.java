package ArrayList.leetcode.easy;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
    /**
     * ===================================
     * 
     * 118. Pascal's Triangle
     * 
     * ===================================
     */

    // This method generates Pascal's Triangle up to numRows
    public List<List<Integer>> generate(int numRows) {
        // This will store the final triangle (list of rows)
        List<List<Integer>> result = new ArrayList<>();

        // Loop through each row
        for (int i = 0; i < numRows; i++) {

            // Create a new row
            List<Integer> row = new ArrayList<>();

            // Each row has i+1 elements
            for (int j = 0; j <= i; j++) {

                // First and last element of every row is always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Get the previous row
                    List<Integer> prevRow = result.get(i - 1);

                    // Current value = sum of two values from previous row
                    // prevRow[j-1] + prevRow[j]
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }

            // Add the completed row to the result
            result.add(row);
        }

        // Return the final Pascal's Triangle
        return result;
    }

    public static void main(String[] args) {
        // Scanner to take input from user
        Scanner sc = new Scanner(System.in);

        // Ask user for number of rows
        System.out.print("Input(numRows) : ");
        int numRows = sc.nextInt();

        // Create object of PascalTriangle class
        PascalTriangle obj = new PascalTriangle();

        // Print the generated Pascal Triangle
        System.out.println("Output : ");
        System.out.println(obj.generate(numRows));

        sc.close();
    }
}