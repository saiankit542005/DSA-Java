package Array.leetcode.easy;

public class ShuffleArr {
    public static void printSuffleArray(int nums[],int n){
        int shuffleArr[] = new int[nums.length];
        int j = 0;
        for(int i=0;i<nums.length-n;i++){
            shuffleArr[j] = nums[i];
            j++;
            shuffleArr[j] = nums[n+i];
            j++;
        }

        for(int k=0;k<shuffleArr.length;k++){
            System.out.print(shuffleArr[k] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // int nums[] = {2,5,1,3,4,7};
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        int n = 5;

        System.out.println("Input : ");
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        System.out.println("Output : ");
        printSuffleArray(nums, n);
    }
}
