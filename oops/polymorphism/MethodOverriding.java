package polymorphism;

public class MethodOverriding {
    public static void main(String[] args) {
        Deer d1 = new Deer(); // derived class object create
        d1.eat();
        Animal a1 = new Animal(); // base class object create
        a1.eat();

    }
}

/*
 * Run Time Polymorphism :=======>
 * => Method Overriding : Base and Derived class both contain the same method
 * with a different definition
 * when we create derived class object then derived class method will call
 * when we create base class object then base class method will call
 * 
 */

class Animal {
    public void eat() {
        System.out.println("eat anyth");
    }
}

class Deer extends Animal {
    public void eat() {
        System.out.println("Deer eats grass");
    }
}