package Array.leetcode.easy;

import java.util.Scanner;

public class SumOfDigit {

  // 1945. Sum of Digits of String After Convert.

  public int getLucky(String s, int k) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      int value = s.charAt(i) - 'a' + 1;
      sb.append(value);
    }

    String str = sb.toString();

    for (int i = 0; i < k; i++) {
      int sum = 0;

      for (int j = 0; j < str.length(); j++) {
        sum += str.charAt(j) - '0';
      }

      str = String.valueOf(sum);
    }
    return Integer.parseInt(str);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter String : ");
    String s = sc.nextLine();

    System.out.print("Enter integer k : ");
    int k = sc.nextInt();


    SumOfDigit obj = new SumOfDigit();
    System.out.println(obj.getLucky(s, k));

    sc.close();
  }
}