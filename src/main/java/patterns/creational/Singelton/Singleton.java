package patterns.creational.Singelton;

public class Singleton {

    public static void main(String[] args) {

        ABC instance = ABC.getInstance();
        System.out.println(instance.hashCode());

        ABC instance2 = ABC.getInstance();
        System.out.println(instance2.hashCode());
    }
}

class ABC {
    static ABC abc = new ABC();

    private ABC() {
    }

    public static ABC getInstance() {
        return abc;
    }
}
