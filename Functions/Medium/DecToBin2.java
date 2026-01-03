package Medium;

public class DecToBin2 {
    // decimal to binary using StringBuilder
    public static void decimalToBin(int n) {
        int myNum = n;

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int rem = n % 2; // binary digit
            sb.append(rem); // add digit
            n = n / 2;
        }

        // reverse because digits are added in reverse order
        sb.reverse();

        System.out.println("binary form of " + myNum + " = " + sb.toString());
    }

    public static void main(String[] args) {
        decimalToBin(10);
    }
}
