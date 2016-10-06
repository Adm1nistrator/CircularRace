/**
 * Created by Aleksey on 03.10.2016.
 */
public class Motorcycle extends Vehicle {
    Boolean hasSidecar;


    Motorcycle(String name, Integer speed, Double probabilityOfPuncture, Boolean hasSidecar) {
        super(name, speed, probabilityOfPuncture);
        this.hasSidecar=hasSidecar;

    }
    @Override
    String getAddInformation() {
        return  hasSidecar ? "Есть коляска" : "Нет коляски";
    }
}
