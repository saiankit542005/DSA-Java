package oops.Inheritance;


public class Basic {
    public static void main(String[] args) {
        Fish shark = new Fish("shark");
        System.out.println("Name : " + shark.name);
        shark.display();//parentClass method call
        shark.show(); //DerivedClass method call
    }
}

// ================= Parent or Base class =====================
class Animal {
    String name;
    String color;

    void display() {
        System.out.println("Parent class method");
    }

    void eat(){
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("brathe");

    }

    void color() {
        System.out.println("color");
    }
}

// ================= Child or Derived class =====================

class Fish extends Animal {
    String name;

    public Fish(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("Child class method");
    }

    void swim(){
        System.out.println("Fish swimming");
    }
}
