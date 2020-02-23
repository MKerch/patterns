package patterns.structural;

public class Proxy {
    public static void main(String[] args) {
        CarI carI = new Carproxy();
        carI.drive();
    }
}

interface CarI {
    void drive();
}

class Reno implements CarI {

    @Override
    public void drive() {
        System.out.println("Reno drive");
    }
}

class Carproxy implements CarI {

    CarI reni = new Reno();

    @Override
    public void drive() {
        System.out.println("+ Proxy");
        reni.drive();
    }
}
