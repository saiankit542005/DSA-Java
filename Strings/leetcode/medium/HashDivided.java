package Strings.leetcode.medium;

public class HashDivided {
    public String stringHash(String s, int k) {
        char ch;
        int sum = 0;
        int n = s.length();
         int value;
        char result[] = new char[n/k];
        int idx = 0;
        int modVal;

        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 0) {
            String curr = sb.substring(0, k);

            for (int i = 0; i < curr.length(); i++) {
                ch = curr.charAt(i);
                value = ch - 'a'; 
                sum += value; 
            }

            modVal = sum % 26;
            sum = 0;//updated sum 

            result[idx] = (char) (modVal + 'a');
            idx++;

            sb.delete(0, k);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;

        HashDivided obj = new HashDivided();
        System.out.println("Input : "+s);
        System.out.println("Output : "+obj.stringHash(s, k));
    }
}