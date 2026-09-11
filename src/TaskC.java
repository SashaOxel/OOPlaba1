import java.util.Scanner;

// Пункт c: определить среднее число встречаемости элементов
// в двумерном целочисленном массиве.
// Среднее = всего элементов / количество различных элементов.
public class TaskC {

    public static void run(Scanner scanner) {
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        int[][] array = new int[rows][cols];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();

        int total = rows * cols;
        int[] all = new int[total];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                all[k] = array[i][j];
                k++;
            }
        }

        int different = 0;
        for (int i = 0; i < total; i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (all[j] == all[i]) {
                    alreadySeen = true;
                }
            }
            if (!alreadySeen) {
                different++;
            }
        }

        double average = (double) total / different;
        System.out.println("Всего элементов: " + total);
        System.out.println("Различных элементов: " + different);
        System.out.println("Среднее число встречаемости элементов: " + average);
    }
}
