package patterns.creational.Factory;

public class FactoryMethod {

    public static void main(String[] args) {

        OS open = getInstance("A");
        open.spec();
    }

    static OS getInstance(String s) {
        if (s.equals("Open")) {
            return new IOS();
        } else if (s.equals("Close")) {
            return new Android();
        } else
            return new Nokia();
    }

}
