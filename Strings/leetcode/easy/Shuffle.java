package Strings.leetcode.easy;

public class Shuffle {
    public String restoreString(String s, int[] indices) {
       char ans[] = new char[s.length()];

       for(int i=0;i<indices.length;i++){
        ans[indices[i]] = s.charAt(i);
       }

        return new String(ans);
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int indices[] = { 4, 5, 6, 7, 0, 2, 1, 3 };

        Shuffle obj = new Shuffle();
        String ans = obj.restoreString(s,indices);

        for(int i=0;i<ans.length();i++){
           char curr = ans.charAt(i);
           System.out.print(curr);
        }
        System.out.println();
    }
}
