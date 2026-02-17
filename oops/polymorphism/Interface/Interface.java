package polymorphism.Interface;

public class Interface {
    public static void main(String[] args) {
        King k1 = new King();
        k1.move();
        
    }
}

interface ChessPlayer {
    void move();
}

class Queen implements ChessPlayer{
    public void move(){
        System.out.println("up,down,left,rigth,diagonal(in all four direction)");
    }
}
class King implements ChessPlayer{
    public void move(){
        System.out.println("up,down,left,rigth,digonal(by 1 step)");
    }
}
class Rook implements ChessPlayer{
    public void move(){
        System.out.println("up,down,left,rigth,diagonal(in all four direction)");
    }
}



/*
 * 
 * Interface in Java :======= >
 * Java me Interface ek pure abstraction ka concept hota hai.
 * Iska use mainly Polymorphism, Multiple Inheritance, aur Loose Coupling ke
 * liye hota hai.
 * 
 * Interface kya hota hai? (Simple words) :=====>
 * Interface ek contract hota hai jo batata hai “class kya-kya karegi”, lekin
 * “kaise karegi” nahi batata.
 * 
 * Interface ki main properties
 * interface keyword se banta hai
 * Iska object nahi ban sakta
 * Class interface ko implements karti hai
 * 
 * Interface me: ==>
 * Methods by default abstract hote hain
 * Variables by default public static final hote hain
 * 
 * Interface vs Abstract Class (short difference)
 * Abstract Class => Interface
 * Partial abstraction => 100% abstraction
 * Constructor hota hai => Constructor ❌
 * Instance variables ho sakte hain => Sirf constants
 * extends => implements
 * Single inheritance => Multiple inheritance supported
 * 
 * 
 * Interface kyu use karte hain? :=====>
 * Multiple inheritance achieve karne ke liye
 * Loose coupling (code flexible hota hai)
 * Polymorphism ke liye
 * Jab sirf behavior define karna ho
 * 
 * Real-life example (easy) :=====>
 * Socho:==>
 * Payment → interface
 * UPI, Card, Cash → classes
 * 
 * Payment interface define karega:==>
 * pay()
 * UPI / Card apna-apna implementation denge.
 * ➡️ Ek hi reference, multiple forms = Polymorphism
 * 
 * 
 * Important exam / interview points
 * Interface ke methods by default:==>
 * public abstract
 * 
 * Interface ke variables by default:==>
 * public static final
 * 
 * Ek class multiple interfaces implement kar sakti hai
 * Interface interface ko extends karta hai
 * 
 * One-line definition (yaad rakhne ke liye) :======>
 * Java me interface ek blueprint hai jo classes ke liye rules define karta hai
 * aur multiple inheritance & polymorphism ko support karta hai.
 * 
 */