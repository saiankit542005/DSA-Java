package oops.Inheritance;


public class SingleLevelInheri {
    public static void main(String[] args) {

        Car c1 = new Car();
        c1.name = "BMW";
        System.out.println("Name of car is : " + c1.name);
        System.out.println("==== Derived class method called");
        c1.Ac();
        c1.musicSystem();
        System.out.println("==== Base class method called");
        c1.speed();
        c1.fuel();
        c1.engine();
    }
}

class Vehicle {
    void speed() {
        System.out.println("Speed is 50km/h");
    }

    void fuel() {
        System.out.println("fuel");
    }

    void engine() {
        System.out.println("this is engine");
    }
}

class Car extends Vehicle {
    String name;

    void Ac() {
        System.out.println("On Ac of this car");
    }

    void musicSystem() {
        System.out.println("Start music");
    }
}
