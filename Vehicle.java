import java.util.concurrent.TimeUnit;


/**
 * Created by Aleksey on 03.10.2016.
 */
public class Vehicle implements Runnable{
    private String name;
    private Integer speed;
    private Double probabilityOfPuncture;
    private Double circleLenght;
    private Double endTime;



    Vehicle(String name, Integer speed, Double probabilityOfPuncture,Double circleLenght) {
        this.name = name;
        this.speed = speed;
        this.probabilityOfPuncture = probabilityOfPuncture;
        this.circleLenght=circleLenght;
    }


    void getAdditionalParameters() {

    }


    @Override
    public void run() {
        System.out.println("Транспортное средство: " + name + " Скорость: " + speed + " Вероятность прокола колеса: " + probabilityOfPuncture);

        // Date date = new Date();
        //Long timeStart = date.getTime();

        Long timeStart = System.currentTimeMillis();
        Double distance = 0.0;
        Double timeFinish = circleLenght/speed;
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
            if (Math.random()<probabilityOfPuncture)
            {
                punctureTime=2000;
                try {
                    TimeUnit.MILLISECONDS.sleep(punctureTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(name+" ремонтируем колесо: "+punctureTime);

            } else punctureTime=0;
           Double currentTime=(double)((System.currentTimeMillis()-timeStart-punctureTime)/1000);

            timeFinish=timeFinish+(punctureTime/1000);
            distance = speed * currentTime;
            System.out.println("Транспортное средство: " + name + " прошло путь: " + distance);
        }
        endTime =timeFinish;

    }

    Double getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }
}
