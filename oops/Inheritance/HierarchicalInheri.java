package oops.Inheritance;

public class HierarchicalInheri {
    public static void main(String[] args) {

        RacingHorse rh = new RacingHorse();
        WorkHorse wh = new WorkHorse();
        PoliceHorse ph = new PoliceHorse();
        System.out.println("=== Racing horse");
        rh.food();
        rh.run();
        System.out.println();

        System.out.println("=== Work horse");
        wh.food();
        wh.show();
        System.out.println();

        System.out.println("=== Police horse");
        ph.food();
        ph.show();
    }
}

// ============== Base class =====================
class Hourse {
    void food() {
        System.out.println("it eats food");
    }

    void sleep() {
        System.out.println("it sleeps");
    }

}

// ========== Derived class 1 extends Base class ===========
class RacingHorse extends Hourse {
    void run() {
        System.out.println("it can run fast");
    }

}

// ========== Derived class 2 extends Base class ===========
class WorkHorse extends Hourse {
    void show() {
        System.out.println("it is a work horse");
    }
}

// ========== Derived class 3 extends Base class ===========
class PoliceHorse extends Hourse {
    void show() {
        System.out.println("it is a police horse");
    }
}
