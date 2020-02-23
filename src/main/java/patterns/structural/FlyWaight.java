package patterns.structural;

import java.util.HashMap;
import java.util.Map;

public class FlyWaight {
    //if we have one object already then second one will not be created
    public static void main(String[] args) {
        FlyWeightGarage garage = new FlyWeightGarage();
        Mercedes mercedes = garage.getMercedes("green");
        Mercedes mercedes2 = garage.getMercedes("green");
        System.out.println(mercedes.color + "hashcode " + mercedes.hashCode());
        System.out.println(mercedes2.color + "hashcode "+ mercedes2.hashCode());
    }
}

class Mercedes {
    String color;
}

class FlyWeightGarage {
    Map<String, Mercedes> map = new HashMap<String, Mercedes>();

    Mercedes getMercedes(String color) {
        Mercedes mercedes = map.get(color);
        if (mercedes == null) {
            mercedes = new Mercedes();
            mercedes.color = color;
            map.put(color, mercedes);
        }
        return mercedes;
    }
}
