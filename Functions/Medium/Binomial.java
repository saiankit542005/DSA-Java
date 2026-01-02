package Medium;

import java.util.Scanner;

public class Binomial {
  // Find binomial Coefficiant
  public static int fact(int n) {
    int f = 1;
    for (int i = 1; i <= n; i++) {
      f *= i;
    }
    return f; // f is factorial of n;

  }

  public static int binCoeff(int n, int r) {
    if (r > n) {
      return 0;
    }

    int fact_n = fact(n);
    int fact_r = fact(r);
    int fact_nmr = fact(n - r);
    int binomialCoeff = fact_n / (fact_r * fact_nmr);
    return binomialCoeff;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter n :");
    int n = sc.nextInt();
    System.out.print("Enter r :");
    int r = sc.nextInt();

    sc.close();
    int output = binCoeff(n, r);// fun call
    System.out.println("binomial Coefficient is : " + output);
  }
}