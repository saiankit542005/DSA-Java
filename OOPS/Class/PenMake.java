package Class;

public class PenMake {
    public static void main(String[] args) {
        Pen p1 = new Pen(); // created a Pen object , p1 is name of referece variable
        Pen p2 = new Pen(); // created a Pen object , p2 is name of referece variable
        p1.setName("Selo"); // Argument(Actual value)
        p1.setColor("blue");// Argument(Actual value)
        p1.setPrice(5); // Argument(Actual value)

        System.out.println("== Pen Object Property==");
        System.out.println("1.");
        System.out.println("Name : " + p1.name);
        System.out.println("Color : " + p1.color);
        System.out.println("Price : " + p1.price);

        p2.setName("Selo");
        p2.setColor("black");
        p2.color = "red";
        p2.setPrice(5);

        System.out.println("2.");
        System.out.println("Name : " + p2.name);
        System.out.println("Color : " + p2.color);
        System.out.println("Price : " + p2.price);

    }

}

class Pen { 
    String name; 
    String color;
    int price;

    // Methods of Pen Object
    void setName(String newName) {
        name = newName;
    }

    void setColor(String newColor) {
        color = newColor;
    }

    void setPrice(int newPrice) {
        price = newPrice;
    }
}
