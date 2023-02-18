package Task_2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Вася");
        Cactus cactus = new Cactus();
        Sensor sensor = new Sensor();
        Calendar lastWateringDate = new GregorianCalendar();
        Calendar currentTime = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("     Введите дату последнего полива: ");
        dateEnter(lastWateringDate, sc);
        System.out.println("     Введите текущую дату: ");
        dateEnter(currentTime, sc);
        sc.close();
        System.out.println("Текущая дата: " + df.format(currentTime.getTime()));
        long lastDate = lastWateringDate.getTimeInMillis();
        long diff = currentTime.getTimeInMillis() - lastWateringDate.getTimeInMillis();
        long days = diff / 86400000;
        int month = lastWateringDate.get(Calendar.MONTH) + 1;
        nextWatering(month, lastWateringDate);

        if (currentTime.getTimeInMillis() > lastDate && currentTime.getTimeInMillis() < lastWateringDate.getTimeInMillis() && days < 2) {
            cactus.setNeedWater(false);
            cactus.status(cactus.getNeedWater());
        } else {
            month = lastWateringDate.get(Calendar.MONTH) + 1;
            if (Calendar.MONTH == 6 || Calendar.MONTH == 7 || Calendar.MONTH == 8) {
                if (sensor.getAirHumidity() < 30) {
                    cactus.setNeedWater(true);
                    cactus.status(cactus.getNeedWater());
                    human.watering(cactus);
                    nextWatering(month, currentTime);
                } else {
                    cactus.setNeedWater(false);
                    cactus.status(cactus.getNeedWater());
                }
            } else {
                cactus.setNeedWater(true);
                cactus.status(cactus.getNeedWater());
                human.watering(cactus);
                nextWatering(month, currentTime);
            }
        }
    }

    public static void nextWatering(int month, Calendar date) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        switch (month) {
            case 12, 1, 2:
                date.add(Calendar.MONTH, 1);
                System.out.println("Дата следующего полива: " + df.format(date.getTime()));
                break;
            case 3, 4, 5, 9, 10, 11:
                date.add(Calendar.WEEK_OF_MONTH, 1);
                System.out.println("Дата следующего полива: " + df.format(date.getTime()));
                break;
            case 6, 7, 8:
                date.add(Calendar.DAY_OF_MONTH, 2);
                System.out.println("Дата следующего полива: " + df.format(date.getTime()));
                break;
        }
    }

    public static void dateEnter(Calendar date, Scanner sc) {
        System.out.print("Введите год: ");
        date.set(Calendar.YEAR, sc.nextInt());
        System.out.print("Введите месяц: ");
        date.set(Calendar.MONTH, sc.nextInt() - 1);
        System.out.print("Введите день: ");
        date.set(Calendar.DAY_OF_MONTH, sc.nextInt());
        System.out.println();
    }
}

