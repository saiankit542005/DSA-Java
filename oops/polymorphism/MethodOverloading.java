package polymorphism;

public class MethodOverloading {

    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.sum(1, 2));
        System.out.println(c1.sum(1, 2, 3));
        System.out.println(c1.sum((float) 1.4, (float) 2.5));// typeCast in float
    }

}

// Compiler Time Polymorphism :======>
// => Method Overloading : multipale method with the same name but different
// parameters
class Calculator {

    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}
