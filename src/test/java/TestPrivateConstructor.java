class A {
    private static A a = null;

    static{
        a= new A();
    }

    private A() {
        //System.out.println("A-con");
    }

    static A getRef() {

        return a;

    }

    void m1() {
        System.out.println("m1-A");
    }
}


public class TestPrivateConstructor {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(A.getRef());
        System.out.println(A.getRef());
        System.out.println(A.getRef());

    }
}
