package Easy;
public class FunOverloading {

    // Function Overloading : same function name but diff. parameters

    public static int sum (int a,int b) {
        return a+b;
    }
     public static int sum (int a,int b,int c) {
        return a+b+c;
    }
    public static float sum(float a , float b) {
        return a+b;
    }

    public static void main(String [] args) {
    
        System.out.println("Sum of two interger num : "+sum(4,5));
        System.out.println("Sum of three integer num : "+sum(5,6,9));
        System.out.println("Sum of two float num : "+ sum(2.3f,4.6f));

    }
}
