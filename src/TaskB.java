import java.util.Scanner;

// Пункт b: удалить из предложения слова, у которых
// первая буква совпадает с последней.
public class TaskB {

    public static void run(Scanner scanner) {
        System.out.print("Введите ваше предложение: ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");

        String result = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }

            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if (first != last) {
                result = result + word + " ";
            }
        }

        System.out.println("Результат: " + result);
    }
}
