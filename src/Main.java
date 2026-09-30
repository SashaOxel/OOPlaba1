import java.util.Scanner;

// Лабораторная работа №1 по ООП. Вариант 15.
// a - сортировка слов по длине, при равной длине - по алфавиту
// b - удаление слов, у которых первая буква совпадает с последней
// c - среднее число встречаемости элементов в двумерном массиве
// d - среднее число встречаемости буквы в предложении
public class Main {

    static MatrixManipulator matrixManipulator;
    static TextManipulator textManipulator;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Выберите пункт:");
            System.out.println("  a - сортировка слов по длине и алфавиту");
            System.out.println("  b - удаление слов с одинаковой первой и последней буквой");
            System.out.println("  c - среднее число встречаемости элементов в массиве");
            System.out.println("  d - среднее число встречаемости буквы в предложении");
            System.out.println("  0 - выход");
            System.out.print("> ");

            String choice = scanner.nextLine();

            if (choice.equals("a")) {
                taskA(scanner);
            } else if (choice.equals("b")) {
                taskB(scanner);
            } else if (choice.equals("c")) {
                taskC(scanner);
            } else if (choice.equals("d")) {
                taskD(scanner);
            } else if (choice.equals("0")) {
                System.out.println("Выход.");
                return;
            } else {
                System.out.println("Неизвестный пункт: " + choice);
            }
        }
    }

    // Пункт a: отсортировать слова в предложении по длине.
    // Если длина одинаковая - сортируем по алфавиту.
    static void taskA(Scanner scanner) {
        System.out.print("Введите ваше предложение: ");

        textManipulator.text= scanner.nextLine();

        System.out.print("Результат: " + textManipulator.sortByLength());
        System.out.println();
    }

    // Пункт b: удалить из предложения слова, у которых
    // первая буква совпадает с последней.
    static void taskB(Scanner scanner) {
        System.out.print("Введите ваше предложение: ");
        textManipulator.text=scanner.nextLine();

        System.out.println("Результат: " + textManipulator.deleteIdentical());
    }

    // Пункт c: определить среднее число встречаемости элементов
    // в двумерном целочисленном массиве.
    // Среднее = всего элементов / количество различных элементов.
    static void taskC(Scanner scanner) {
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        Matrix matrix = new Matrix(rows, cols);
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.setIJ(i,j,scanner.nextInt());
            }
        }
        matrixManipulator=new MatrixManipulator(matrix);
        double average = matrixManipulator.calculateAverage();

        System.out.println("Среднее число встречаемости элементов: " + average);
    }

    // Пункт d: определить среднее число встречаемости буквы в предложении.
    // Среднее = всего букв / количество различных букв.
    static void taskD(Scanner scanner) {
        System.out.print("Введите ваше предложение: ");
        textManipulator.text=scanner.nextLine();

        System.out.println("Среднее число встречаемости буквы: " + textManipulator.detectAverageCountLetters());
    }
}
