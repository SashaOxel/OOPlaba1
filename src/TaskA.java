import java.util.Scanner;

// Пункт a: отсортировать слова в предложении по длине.
// Если длина одинаковая - сортируем по алфавиту.
public class TaskA {

    public static void run(Scanner scanner) {
        System.out.print("Введите ваше предложение: ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                boolean needSwap = false;

                if (words[j].length() > words[j + 1].length()) {
                    needSwap = true;
                } else if (words[j].length() == words[j + 1].length()) {
                    if (words[j].compareTo(words[j + 1]) > 0) {
                        needSwap = true;
                    }
                }

                if (needSwap) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        System.out.print("Результат: ");
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }
}
