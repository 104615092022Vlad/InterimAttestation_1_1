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
        long diff = currentTime.getTimeInMillis() - lastWateringDate.getTimeInMillis();
        long days = diff / 86400000;
        int month = lastWateringDate.get(Calendar.MONTH) + 1;
        nextWatering(month, lastWateringDate);
        int airHumidity = sensor.getAirHumidity();
        System.out.println("Влажность воздуха: " + airHumidity + "%");
        needWatering(month, days, airHumidity, cactus, human, currentTime);
    }

    public static void needWatering(int month, long days, int airHumidity, Cactus cactus, Human human, Calendar currentTime) {
        switch (month) {
            case 12, 1, 2:
                if (days < 30) {
                    cactus.setNeedWater(false);
                    cactus.status(cactus.getNeedWater());
                } else {
                    cactus.setNeedWater(true);
                    cactus.status(cactus.getNeedWater());
                    human.watering(cactus);
                    month = currentTime.get(Calendar.MONTH) + 1;
                    nextWatering(month, currentTime);
                }
                break;
            case 3, 4, 5, 9, 10, 11:
                if (days < 7) {
                    cactus.setNeedWater(false);
                    cactus.status(cactus.getNeedWater());
                } else {
                    cactus.setNeedWater(true);
                    cactus.status(cactus.getNeedWater());
                    human.watering(cactus);
                    month = currentTime.get(Calendar.MONTH) + 1;
                    nextWatering(month, currentTime);
                }
                break;
            case 6, 7, 8:
                if (days < 2 || airHumidity > 30) {
                    cactus.setNeedWater(false);
                    cactus.status(cactus.getNeedWater());
                } else {
                    cactus.setNeedWater(true);
                    cactus.status(cactus.getNeedWater());
                    human.watering(cactus);
                    month = currentTime.get(Calendar.MONTH) + 1;
                    nextWatering(month, currentTime);
                }
                break;
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

