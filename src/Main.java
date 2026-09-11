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
                TaskA.run(scanner);
            } else if (choice.equals("b")) {
                TaskB.run(scanner);
            } else if (choice.equals("c")) {
                TaskC.run(scanner);
            } else if (choice.equals("d")) {
                TaskD.run(scanner);
            } else if (choice.equals("0")) {
                System.out.println("Выход.");
                return;
            } else {
                System.out.println("Неизвестный пункт: " + choice);
            }
        }
    }
}
