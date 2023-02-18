package Task_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Message {
    public static void main(String[] args) {
        int messageLength = getMessageLength();
        boolean trigger = true;
        while (trigger) {
            trigger = inputFenceLength(trigger, messageLength);
        }
    }

    public static int getMessageLength() {
        String message = "Я тебя очень люблю";
        String letters = message.replaceAll(" ", "");
        String spaces = message.replaceAll("[А-Яа-я]", "");
        int lettersQuantity = letters.length();
        int spacesQuantity = spaces.length();
        int messageLength = 62 * lettersQuantity / 3 + 12 * spacesQuantity / 2;
        return messageLength;
    }

    public static boolean inputFenceLength (boolean trigger, int messageLength) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину забора в см: ");
        try {
            int lengthFence = sc.nextInt();
            if (lengthFence >= 0) {
                if (lengthFence >= messageLength ) {
                    System.out.println("Надпись поместится");
                } else {
                    System.out.println("Надпись не поместится");
                }
                trigger = false;
            } else {
                System.out.println("Длина должна быть больше нуля!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ответ должен содержать целое число!");
        }
        return trigger;
    }
}
