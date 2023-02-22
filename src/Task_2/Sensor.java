package Task_2;

import java.util.Random;

public class Sensor {
    Random r = new Random();
    private int airHumidity = r.nextInt(0, 100);

    public int getAirHumidity() {
        return airHumidity;
    }
}
