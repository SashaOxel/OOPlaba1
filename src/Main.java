import java.util.Arrays;
import java.util.Scanner;

// Лабораторная работа №1 по ООП. Вариант 15.
// a - сортировка слов по длине, при равной длине - по алфавиту
// b - удаление слов, у которых первая буква совпадает с последней
// c - среднее число встречаемости элементов в двумерном массиве
// d - среднее число встречаемости буквы в предложении
// e - тестирование конструкторов (лабораторная работа №2)
public class Main {

    static MatrixManipulator matrixManipulator;
    static TextManipulator textManipulator = new TextManipulator();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Выберите пункт:");
            System.out.println("  a - сортировка слов по длине и алфавиту");
            System.out.println("  b - удаление слов с одинаковой первой и последней буквой");
            System.out.println("  c - среднее число встречаемости элементов в массиве");
            System.out.println("  d - среднее число встречаемости буквы в предложении");
            System.out.println("  e - тестирование конструкторов");
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
            } else if (choice.equals("e")) {
                testConstructors(scanner);
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
        Matrix matrix = readMatrix(scanner);
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

    // Пункт e: тестирование конструкторов.
    // Пользователь выбирает, какой конструктор проверить.
    static void testConstructors(Scanner scanner) {
        System.out.println("Выберите конструктор для проверки:");
        System.out.println("  1 - TextManipulator() - без параметров");
        System.out.println("  2 - TextManipulator(String text) - с параметром");
        System.out.println("  3 - TextManipulator(TextManipulator other) - копирования");
        System.out.println("  4 - Matrix() - без параметров");
        System.out.println("  5 - Matrix(int rows, int cols) - с параметрами");
        System.out.println("  6 - Matrix(Matrix other) - копирования");
        System.out.println("  7 - MatrixManipulator(Matrix matrix) - с параметром");
        System.out.print("> ");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            testTextDefault();
        } else if (choice.equals("2")) {
            testTextParam(scanner);
        } else if (choice.equals("3")) {
            testTextCopy(scanner);
        } else if (choice.equals("4")) {
            testMatrixDefault();
        } else if (choice.equals("5")) {
            testMatrixParam(scanner);
        } else if (choice.equals("6")) {
            testMatrixCopy(scanner);
        } else if (choice.equals("7")) {
            testMatrixManipulator(scanner);
        } else {
            System.out.println("Неизвестный пункт: " + choice);
        }
    }

    // Проверка конструктора без параметров: поле text должно быть пустой строкой.
    static void testTextDefault() {
        TextManipulator text = new TextManipulator();

        System.out.println("Создан объект: new TextManipulator()");
        System.out.println("Значение поля text: \"" + text.text + "\"");
        System.out.println("Длина текста: " + text.text.length());
    }

    // Проверка конструктора с параметром: поле text должно совпасть с введённым текстом.
    static void testTextParam(Scanner scanner) {
        System.out.print("Введите текст: ");
        String input = scanner.nextLine();
        TextManipulator text = new TextManipulator(input);

        System.out.println("Создан объект: new TextManipulator(\"" + input + "\")");
        System.out.println("Значение поля text: \"" + text.text + "\"");
    }

    // Проверка конструктора копирования: копия - новый объект с тем же текстом.
    // После изменения оригинала копия должна сохранить старый текст.
    static void testTextCopy(Scanner scanner) {
        System.out.print("Введите текст для оригинала: ");
        TextManipulator original = new TextManipulator(scanner.nextLine());
        TextManipulator copy = new TextManipulator(original);

        System.out.println("Оригинал: \"" + original.text + "\"");
        System.out.println("Копия:    \"" + copy.text + "\"");
        System.out.println("Текст совпадает: " + original.text.equals(copy.text));
        System.out.println("Один и тот же объект (original == copy): " + (original == copy));

        System.out.print("Введите новый текст для оригинала: ");
        original.text = scanner.nextLine();

        System.out.println("После изменения оригинала:");
        System.out.println("Оригинал: \"" + original.text + "\"");
        System.out.println("Копия:    \"" + copy.text + "\"");
    }

    // Проверка конструктора без параметров: матрица 2 x 2, заполненная нулями.
    static void testMatrixDefault() {
        Matrix matrix = new Matrix();

        System.out.println("Создан объект: new Matrix()");
        System.out.println("Размер: " + matrix.getRows() + " x " + matrix.getCols());
        System.out.println("Элементы:");
        matrix.print();
    }

    // Проверка конструктора с параметрами: матрица заданного размера, заполненная нулями.
    static void testMatrixParam(Scanner scanner) {
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();
        scanner.nextLine();

        Matrix matrix = new Matrix(rows, cols);

        System.out.println("Создан объект: new Matrix(" + rows + ", " + cols + ")");
        System.out.println("Размер: " + matrix.getRows() + " x " + matrix.getCols());
        System.out.println("Количество элементов: " + matrix.countCells());
        System.out.println("Элементы:");
        matrix.print();
    }

    // Проверка конструктора копирования матрицы: копия - новый объект со своим массивом.
    // После изменения элемента оригинала копия должна остаться прежней.
    static void testMatrixCopy(Scanner scanner) {
        Matrix original = readMatrix(scanner);
        Matrix copy = new Matrix(original);

        System.out.println("Оригинал:");
        original.print();
        System.out.println("Копия:");
        copy.print();
        System.out.println("Элементы совпадают: " + Arrays.deepEquals(original.getTemp(), copy.getTemp()));
        System.out.println("Один и тот же объект (original == copy): " + (original == copy));
        System.out.println("Общий массив элементов: " + (original.getTemp() == copy.getTemp()));

        System.out.print("Введите новое значение для элемента [0][0] оригинала: ");
        original.setIJ(0, 0, scanner.nextInt());
        scanner.nextLine();

        System.out.println("После изменения оригинала:");
        System.out.println("Оригинал:");
        original.print();
        System.out.println("Копия:");
        copy.print();
    }

    // Проверка конструктора MatrixManipulator: объект запоминает переданную матрицу
    // (ссылку на неё, а не копию) и выполняет над ней вычисления.
    static void testMatrixManipulator(Scanner scanner) {
        Matrix matrix = readMatrix(scanner);
        MatrixManipulator manipulator = new MatrixManipulator(matrix);

        System.out.println("Создан объект: new MatrixManipulator(matrix)");
        System.out.println("Хранит ту же матрицу (manipulator.matrix == matrix): " + (manipulator.matrix == matrix));
        System.out.println("Среднее число встречаемости элементов: " + manipulator.calculateAverage());
    }

    // Ввод матрицы с клавиатуры.
    static Matrix readMatrix(Scanner scanner) {
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
        // убираем перевод строки, оставшийся после nextInt()
        scanner.nextLine();
        return matrix;
    }
}
