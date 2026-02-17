package polymorphism.abstraction;

public class AbstractClass2 {
    public static void main(String[] args) {
        // Collge c = new College(); // con't create abstract class object

        AnkitSaini s1 = new AnkitSaini();
        //College(Base class) => Student(derived class of Collge) => AnkitSaini(derived class of Student)
    }

}

abstract class College {
    public College() {
        System.out.println("Collgege class Constructor called");
    }
}

class Student extends College {
    public Student() {
        System.out.println("Studnet class constructor called");
    }

}

class AnkitSaini extends Student {
    public AnkitSaini() {
        System.out.println("AnkitSaini class construcator called");
    }

}