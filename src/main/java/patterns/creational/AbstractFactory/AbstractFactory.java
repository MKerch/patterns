package patterns.creational.AbstractFactory;

public class AbstractFactory {

    public static void main(String[] args) {
        MyAbstractFactory myAbstractFactory = new MyAbstractFactory();
        CarFactory car = (CarFactory) myAbstractFactory.createFactory("Car");
        Car bmw = car.typeOfCar("BMW");
        System.out.println(bmw);
        TankFactory tankFactory = (TankFactory) myAbstractFactory.createFactory("Tank");
        Tank bmwTank = tankFactory.typeOfCar("BMWTank");
        System.out.println(bmwTank);
    }
}

interface Car {
    void drive();
}

class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Audi is driving well");
    }
}

class BMW implements Car {
    @Override
    public void drive() {
        System.out.println("BMW is not bad");
    }
}

class CarFactory implements Factory {
    public Car typeOfCar(String typeOfcar) {
        switch (typeOfcar) {
            case "BMW":
                return new BMW();
            case "Audi":
                return new Audi();
            default:
                return null;
        }
    }
}

interface Tank {
    void drive();
}

class AudiTank implements Tank {
    @Override
    public void drive() {
        System.out.println("Audi is driving well");
    }
}

class BMWTank implements Tank {
    @Override
    public void drive() {
        System.out.println("BMW is not bad");
    }
}

class TankFactory implements Factory {
    public Tank typeOfCar(String typeOftank) {
        switch (typeOftank) {
            case "BMWTank":
                return new BMWTank();
            case "AudiTank":
                return new AudiTank();
            default:
                return null;
        }
    }
}

interface Factory<T> {
    T typeOfCar(String animalType);
}

class MyAbstractFactory {
    Factory createFactory(String factoryName) {
        switch (factoryName) {
            case "Car":
                return new CarFactory();
            case "Tank":
                return new TankFactory();
            default:
                return null;
        }
    }
}