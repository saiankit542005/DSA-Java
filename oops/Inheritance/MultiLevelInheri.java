package oops.Inheritance;

public class MultiLevelInheri {
    public static void main(String[] args) {
        Student ankit = new Student("Ankit", 21);

        System.out.println("Name : " + ankit.name);
        ankit.study();
        ankit.branch();
        ankit.think();
        ankit.speak();
    }
}

// =========== Base Class =============
class LivingBeing {

    void Saans() {
        System.out.println("Saans");
    }

    void grow() {
        System.out.println("Growing");
    }

    void food() {
        System.out.println("He is eating food");
    }

    void Move() {
        System.out.println("He can Move");
    }
}

// =========== Derived Class 1 extends Base class ===============
class Humans extends LivingBeing {

    void think() {
        System.out.println("He is thinking");
    }

    void speak() {
        System.out.println("speaking");
    }

}

// =========== Derived Class 2 extends Derived class 1 =============
class Student extends Humans {
    String name;
    int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    void study() {
        System.out.println("He is studing");
    }

    void branch() {
        System.out.println("Branch is Computer Science");
    }
}
