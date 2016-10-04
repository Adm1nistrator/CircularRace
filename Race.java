import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Aleksey on 03.10.2016.
 */
public class Race extends Thread {
    public static void main(String[] args) throws InterruptedException, IOException {
        Double circleLength = 2000.00;
        Truck truck = new Truck("Грузовик", 90, 0.1, circleLength);
        Car car = new Car("Легковушка", 160, 0.3, circleLength);
        Motorcycle motorcycle = new Motorcycle("Мотоцикл", 233, 0.2, circleLength);

        while (true) {
            Thread thread1 = new Thread(truck, "грузовик");
            Thread thread2 = new Thread(car, "легковушка");
            Thread thread3 = new Thread(motorcycle, "мотоцикл");

            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();

            TreeMap<Double, String> treeMap = new TreeMap<>();
            treeMap.put(truck.getEndTime(), truck.getName());
            treeMap.put(car.getEndTime(), car.getName());
            treeMap.put(motorcycle.getEndTime(), motorcycle.getName());

            System.out.println();

            for (Map.Entry position : treeMap.entrySet()) {

                System.out.println("Транспортное средство: " + position.getValue() + " закончил круг за: " + position.getKey() + " секунды");
            }

            System.out.println("Повторить заезд Да\\Нет(Y\\N)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();

            if (string.equals("нет") || string.equals("n"))
                break;


        }

    }
}
