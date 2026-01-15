package Constructor;

public class School {
    public static void main(String[] args) {
        /*
         * When the Student() constructor is called, the parameters are checked to see
         * what parameters are present inside the Student() constructor. When the
         * parameters match, that constructor is called.
         * 
         */
        Student s2 = new Student(); //Object2

        Student s1 = new Student(1, "Ankit", 20, "ankit@pass"); //Object1
        System.out.println(s1);
        System.out.println("Student Id : " + s1.studentId);
        System.out.println("Name : " + s1.name);
        System.out.println("Age  : " + s1.age);
        System.out.println("Password : " + s1.password);
        s1.marks[0] = 90;
        s1.marks[1] = 75;
        s1.marks[2] = 80;
        System.out.print("Marks : ");
        for (int i = 0; i < 3; i++) {
            System.out.print(s1.marks[i] + " ");
        }
        System.out.println();

        Student s3 = new Student(s1); //Object3
        s3.password = "ankit@123";
        System.out.println("Student Id : " + s3.studentId);
        System.out.println("Name : " + s3.name);
        System.out.println("Updated Password : " + s3.password);
        s3.marks[0] = 100; // marks updated -> shallow copy hoga
        System.out.println("Updated s1 marks[0] : " + s1.marks[0]);
        System.out.print("Marks : ");
        for (int i = 0; i < 3; i++) {
            System.out.print(s3.marks[i] + " ");
        }
        System.out.println();

    }
}

class Student {
    int studentId;
    String name;
    int age;
    String password;
    int[] marks;

    //User-defined Default Constructor :===>
    public Student() {
        System.out.println("Default Constructor is called");
    }

    //Parameterized Constructor :==>
    public Student(int studentId, String name, int age, String psd) {
        System.out.println("Parameterized Constructor is calling......");
        this.name = name;
        this.studentId = studentId;
        this.age = age;
        this.password = psd;
        this.marks = new int[3];
    }

    // Copy Constructor :==>
    public Student(Student original) {
        System.out.println("Copy Constructor is calling ....");
        this.studentId = original.studentId;
        this.name = original.name;
        this.marks = original.marks;
    }
}


/*
 * user-defined Default Constructor , When user not defined any constructor then
 * Java automatically create a default Constructor.
 * this -> it point current object.
 */

/*
 * If we create multiple constructors, and when a constructor is called, Java
 * does not create a default constructor. Therefore, we have to create
 * user-defined constructors; otherwise, an error occurs. Error: The constructor
 * Student() is undefined.
 */