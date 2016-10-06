import java.util.concurrent.TimeUnit;

/**
 * Created by Alexey on 06.10.2016.
 */
public class VehicleRunnable implements Runnable {

    private Vehicle vehicle;
    private Double  circleLenght;
    private Double endTime;

    VehicleRunnable (Vehicle vehicle,Double circleLenght){
        this.vehicle=vehicle;
        this.circleLenght=circleLenght;
    }



    @Override
    public void run() {

        System.out.println(vehicle.name + " Скорость: " + vehicle.speed +
                " Вероятность прокола колеса: " + vehicle.probabilityOfPuncture+" "+vehicle.getAddInformation());

        Long timeStart = System.currentTimeMillis();
        Double distance = 0.0;
        Double finishTime = circleLenght/vehicle.speed;
        try {
            TimeUnit.MILLISECONDS.sleep(2000); //пауза для вывода на консоль
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (distance< circleLenght) {
            try {
                TimeUnit.MILLISECONDS.sleep(500); //пауза для вывода на консоль
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Integer punctureTime=0;
            if (Math.random()<vehicle.probabilityOfPuncture)
            {
                punctureTime=2000;
                try {
                    TimeUnit.MILLISECONDS.sleep(punctureTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(vehicle.name+" ремонтируем колесо: "+punctureTime);

            } else punctureTime=0;
            Double currentTime=(double)((System.currentTimeMillis()-timeStart-punctureTime)/1000);

            finishTime=finishTime+(punctureTime/1000);
            distance = vehicle.speed * currentTime;
            System.out.println(vehicle.name + "в пути: " + distance);
        }
        endTime =finishTime;

    }

    public Double getEndTime() {
        return endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
