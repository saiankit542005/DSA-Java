package Array.leetcode.medium;

public class BeautifulArr {
    public static int[] beautifulArray(int n) {
        int arr[] = new int[n];
        arr[0] = 1;
        int size = 1;

        while (size < n) {
            int temp[] = new int[n];
            int idx = 0;

            // odd Numbers
            for (int i = 0; i < size; i++) {
                int val = 2 * arr[i] - 1;
                if (val <= n) {
                    temp[idx++] = val;
                }
            }

            // Even Number
            for (int i = 0; i < size; i++) {
                int val = 2 * arr[i];
                if (val <= n) {
                    temp[idx++] = val;
                }
            }

            arr = temp;
            size = idx;
        }
        return arr;
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
      int arr[] = beautifulArray(5);
      printArr(arr);
    }
}