import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Aleksey on 03.10.2016.
 */
public class Race {
    public static void main(String[] args) throws InterruptedException, IOException {
        while (true) {

            Double circleLength = 402.336;
            Truck truck = new Truck("Грузовик",25 , 0.0, 880.00);
            Car car = new Car("Легковушка", 50, 0.3, 2);
            Motorcycle motorcycle = new Motorcycle("Мотоцикл", 61, 0.2, true);


            List<VehicleRunnable> vehicles = new ArrayList<>();
            vehicles.add(new VehicleRunnable(truck,circleLength));
            vehicles.add(new VehicleRunnable(car,circleLength));
            vehicles.add(new VehicleRunnable(motorcycle,circleLength));

            TreeMap<Double, String> treeMap = new TreeMap<>();
            List<Thread> threads = new ArrayList<>();

            for (VehicleRunnable vehicle : vehicles) {
                Thread thread = new Thread(vehicle);
                threads.add(thread);
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            for (VehicleRunnable vehicleRunnable : vehicles) {

                treeMap.put(vehicleRunnable.getEndTime(), vehicleRunnable.getVehicle().name);

            }


            System.out.println();

            for (Map.Entry position : treeMap.entrySet()) {

                System.out.println(position.getValue() + " закончил круг за: " + position.getKey() + " секунды");  //// TODO: 06.10.2016 форматирование времени
            }

            System.out.println("Повторить заезд Да\\Нет(Y\\N)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();

            if (string.equals("да") || string.equals("y")) {
                return;
            } else {
                if (string.equals("нет") || string.equals("n")) {
                    break;
                }
            }

        }

    }
}
