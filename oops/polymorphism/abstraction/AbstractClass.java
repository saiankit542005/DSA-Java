package polymorphism.abstraction;

public class AbstractClass { // Abstract class ka object nhi bnta
    public static void main(String[] args) {
        Horse h1 = new Horse();
        h1.eat();
        h1.walk();
        System.out.println("Parent class Animal me Construcor color : " + h1.color);

        // first call parent class constructor
        // Java me jab child class ka object banta hai, chahe parent class abstract ho,
        // sabse pehle parent (abstract) class ka constructor call hota hai.
        
        h1.changeColor();
        System.out.println("Horse class me changeColor() method color : " + h1.color);

        Chicken c1 = new Chicken();
        System.out.println("-------------------------------");
        c1.eat();
        c1.walk();
        c1.changeColor(); // changeColor method of derived class Chicken
        System.out.println("Chicken class me changeColor() method  color : " + c1.color);

        // Animal a = new Anmimal(); abstract class ka object create nhi kr skte hai

    }
}

abstract class Animal {
    String color;

    // constructor
    public Animal() {
        color = "brown";
    }

    void eat() {
        System.out.println("It can eats");
    }

    abstract void walk(); // this method is abstract beacause implementation nhi hai iski.
}

class Horse extends Animal {
    // derived class Horse me base class Animal ka abstract method inherit ho rha
    // so, so "abstract void walk()" <- is abstract method ka child class me
    // impementation likhna pdega
    // return type void hona because abstract walk() method ka return type void hai

    public void walk() {
        System.out.println("walks on 4 legs");
    }

    void changeColor() {
        color = "dark brown";
    }

}

class Chicken extends Animal {
    // Here we also need to implement the walk() method

    void walk() {
        System.out.println("walks on 2 legs");
    }

    void changeColor() {
        color = "yellow";
    }

}


/*
 * Abstract Class :=================>
 * Java me Abstract Class ek aisi class hoti hai jo incomplete (adhूरी) hoti
 * hai, aur jiska main use Polymorphism ko achieve karna hota hai.
 * 
 * Abstract Class kya hoti hai? :====>
 * abstract keyword se banayi jati hai
 * Iska object directly nahi bana sakte
 * 
 * Isme:====>
 * Abstract methods (jinka body nahi hota)
 * Normal methods (jinka body hota hai)
 * dono ho sakte hain
 * 
 * Abstract Method kya hota hai? :===>
 * Sirf method ka name + signature
 * Body {} nahi hoti
 * Child class ko force karta hai ki wo us method ko implement kare
 * 
 * Polymorphism me Abstract Class ka role :====>
 * Polymorphism ka simple matlab
 * Ek reference, multiple forms
 * Abstract class ka reference use karke hum different child classes ke objects
 * ko point kar sakte hain.
 * 
 * Real-life example (samajhne ke liye) ==>
 * Socho ek abstract class hai Vehicle
 * Vehicle → ek concept hai (complete nahi)
 * Car, Bike → Vehicle ke different forms hai
 * 
 * Vehicle ka reference:====>
 * kabhi Car ke behavior ko call karega
 * kabhi Bike ke behavior ko call karega
 * ➡️ Yehi runtime polymorphism hai
 * 
 * Abstract Class kyu use karte hain? :====>
 * Common structure define karne ke liye
 * Child classes ko rules dene ke liye (konse methods implement karne hi honge)
 * Runtime Polymorphism achieve karne ke liye
 * 
 * Jab:====>
 * kuch behavior same ho
 * kuch behavior different ho (child class decide kare)
 * 
 * Important points (exam + interview) :=========>
 * Abstract class ka object ❌
 * Abstract method ho to class bhi abstract hogi
 * Abstract class me constructor ho sakta hai
 * Abstract class variables aur methods dono rakh sakti hai
 * final abstract method ❌ (kyuki override hona zaruri hai)
 * 
 * One-line definition (yaad rakhne ke liye):====== >
 * Java me abstract class ek blueprint hoti hai jo child classes ko method
 * implementation ke liye force karti hai aur polymorphism ko support karti hai.
 */