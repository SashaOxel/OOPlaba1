import java.util.Scanner;

// Пункт d: определить среднее число встречаемости буквы в предложении.
// Среднее = всего букв / количество различных букв.
public class TaskD {

    public static void run(Scanner scanner) {
        System.out.print("Введите ваше предложение: ");
        String line = scanner.nextLine();
        line = line.toLowerCase();

        String letters = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isLetter(c)) {
                letters = letters + c;
            }
        }

        int total = letters.length();

        int different = 0;
        for (int i = 0; i < total; i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (letters.charAt(j) == letters.charAt(i)) {
                    alreadySeen = true;
                }
            }
            if (!alreadySeen) {
                different++;
            }
        }

        if (different == 0) {
            System.out.println("В предложении нет букв.");
            return;
        }

        double average = (double) total / different;
        System.out.println("Всего букв: " + total);
        System.out.println("Различных букв: " + different);
        System.out.println("Среднее число встречаемости буквы: " + average);
    }
}
