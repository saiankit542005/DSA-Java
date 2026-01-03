package Medium;
public class BinToDeci {

    public static void BinaryToDeci(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;

        while(binNum > 0 ) {
            int lastDigit  = binNum % 10;
            decNum = decNum + (int)(lastDigit *Math.pow(2,pow));
            //Math.pow() = > double type ka value return karta hai.
            pow++;
            binNum = binNum/10;

        }
        System.out.println("decima number of "+ myNum+ " = "+decNum);
    }
   public static void main(String[] args) {

    BinaryToDeci(1010101010);
 }
}
