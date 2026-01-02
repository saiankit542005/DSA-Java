package Easy;
public class Swap {
    public static void swap(int a,int b) {
        int temp = a;
        a  = b;
        b = temp;
       
        System.out.println("a in swap function = "+a);
        System.out.println("b in swap function = "+b);
    }
    public static void main(String[] args)  {

        int a = 5;
        int b = 10;
        swap(a,b); 

        System.out.println("a in main function = "+a);
        System.out.println("b in main function = "+b);
     }
}