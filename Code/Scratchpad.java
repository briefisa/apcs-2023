
public class Scratchpad {

    public static void main(String[] args) {
        B b = new B();
    }
}

class A {

    public A() {
        System.out.print("A ");
    }
}

class B extends A {

    public B() {
        super();
        System.out.print("B ");
    }
}