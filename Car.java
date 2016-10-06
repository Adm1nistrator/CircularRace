/**
 * Created by Aleksey on 03.10.2016.
 */
public class Car extends Vehicle {
    Integer passengerCount;

    Car(String name, Integer speed, Double probabilityOfPuncture, Integer passengerCount) {
        super(name, speed, probabilityOfPuncture);
        this.passengerCount=passengerCount;

    }
    @Override
    String getAddInformation() {
        return "Кол-во пассажиров: " + passengerCount;
    }
}
