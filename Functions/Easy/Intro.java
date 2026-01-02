package Easy;
public class Intro {
    //This function basics class ke andar so ham aese functions ko methods khte hai.
    public static void printString() {
        System.out.println("Hello World");
        System.out.println("Hello World");
    }

    public static int calculateSum(int num1, int num2) { // parameters or formal parameters
        int sum = num1 + num2;
        return sum;
    }
    public static void main(String[] args) { // code start from main function
        
        int sumOfNum = calculateSum(5, 5); // function call
        // 5,5 = > arguments or actual parameters or value
        System.out.println("sum is : " + sumOfNum); // print
        System.out.println("sum is : " + calculateSum(5, 5)); // funtion call & print
    }
}