package Strings.leetcode.easy;

public class Reverse2 {
    public void reverse(String s, int k) {
        if (s.length() <= k) {
            System.out.println(new StringBuilder(s).reverse());
            return;
        }
        int i = 0;
        int j = k - 1;
        String curr = "";
        String ans = "";
        char rev[] = new char[k];

        StringBuilder sb = new StringBuilder(s);
        int lenSb = sb.length();

        while (sb.length() > 0) {

            if (lenSb > 2 * k) {

                curr = sb.substring(0, 2 * k);

                while (i < j) {
                    char first = curr.charAt(i);
                    char last = curr.charAt(j);

                    rev[i] = last;
                    rev[j] = first;
                    i++;
                    j--;
                }
                i = 0;
                j = k - 1;
                ans = ans + new String(rev);
                ans = ans + curr.substring(k);

                sb = sb.delete(0, 2 * k);
                lenSb = sb.length();

            } else if (lenSb > k && lenSb < 2 * k) {
                curr = sb.substring(0);
                while (i < j) {
                    char first = curr.charAt(i);
                    char last = curr.charAt(j);

                    rev[i] = last;
                    rev[j] = first;
                    i++;
                    j--;
                }
                i = 0;
                j = k - 1;
                ans = ans + new String(rev);
                ans = ans + curr.substring(k);

                sb = sb.delete(0, 2 * k);
                lenSb = sb.length();

            } else {
                curr = sb.substring(0);
                while (i < j) {
                    char first = curr.charAt(i);
                    char last = curr.charAt(j);

                    rev[i] = last;
                    rev[j] = first;
                    i++;
                    j--;
                }
                i = 0;
                j = k - 1;
                ans = ans + new String(rev);
                ans = ans + curr.substring(k);

                sb = sb.delete(0, 2 * k);
                lenSb = sb.length();

            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;

        Reverse2 obj = new Reverse2();
        obj.reverse(s, k);
    }
}