import java.util.Scanner;

// Лабораторная работа №1 по ООП. Вариант 15.
// a - сортировка слов по длине, при равной длине - по алфавиту
// b - удаление слов, у которых первая буква совпадает с последней
// c - среднее число встречаемости элементов в двумерном массиве
// d - среднее число встречаемости буквы в предложении
public class Main {

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

    // Пункт b: удалить из предложения слова, у которых
    // первая буква совпадает с последней.
    static void taskB(Scanner scanner) {
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

    // Пункт c: определить среднее число встречаемости элементов
    // в двумерном целочисленном массиве.
    // Среднее = всего элементов / количество различных элементов.
    static void taskC(Scanner scanner) {
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

    // Пункт d: определить среднее число встречаемости буквы в предложении.
    // Среднее = всего букв / количество различных букв.
    static void taskD(Scanner scanner) {
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
