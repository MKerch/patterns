package patterns.structural;

public class Adapter {

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        Audi audi = new Audi();
//        carWash.washCar(audi);
        carWash.washCar(new TrackWraper(new MyTrack()));
    }

}

interface Car {
    void wash();
}

class CarWash {
    public void washCar(Car car) {
        car.wash();
    }
}

class Audi implements Car {

    public void wash() {
        System.out.println("Audi washed");
    }
}

interface Track {
    void clean();

}

class MyTrack implements Track {

    public void clean() {
        System.out.println("Track cleaned");
    }
}

class TrackWraper implements Car {

    Track track;

    public TrackWraper(Track track) {
        this.track = track;
    }

    public void wash() {
        track.clean();
    }
}
