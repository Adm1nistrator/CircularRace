/**
 * Created by Aleksey on 03.10.2016.
 */
public class Truck extends Vehicle {
    Double loadWeight;


    Truck(String name, Integer speed, Double probabilityOfPuncture, Double loadWeight) {
        super(name, speed, probabilityOfPuncture);
        this.loadWeight=loadWeight;

    }
    @Override
    String getAddInformation() {
        return "Вес груза:" + loadWeight;
    }




}
