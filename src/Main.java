//Пользователь вводит предложение, отсортировать слова по длине слов и в случае совпадения длины отсортировать по алфавиту.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.print("Введите ваше предложение: ");
        Scanner scanner = new Scanner(System.in);
        var userInput = scanner.nextLine().split(" ");
        String temp;

        for (int i = 0; i < userInput.length - 1; i++) {
                if (userInput[i].length() > userInput[i+1].length()) {
                    temp = userInput[i+1];
                    userInput[i+1] = userInput[i];
                    userInput[i] = temp;
                } else if (userInput[i].length()==userInput[i+1].length()) {
                    if (userInput[i].compareTo(userInput[i+1]) > 0) {
                        temp = userInput[i+1];
                        userInput[i+1] = userInput[i];
                        userInput[i] = temp;
                    }
                }
        }

        IO.println(Arrays.toString(userInput));

    }
}