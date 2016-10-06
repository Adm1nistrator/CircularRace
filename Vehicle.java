import java.util.Objects;
import java.util.concurrent.TimeUnit;


/**
 * Created by Aleksey on 03.10.2016.
 */
abstract class Vehicle {
    final String name;
    final Integer speed;
    final Double probabilityOfPuncture;


    Vehicle(String name, Integer speed, Double probabilityOfPuncture) {
        this.name = name;
        this.speed = speed;
        this.probabilityOfPuncture = probabilityOfPuncture;
    }


    abstract String getAddInformation();



}
