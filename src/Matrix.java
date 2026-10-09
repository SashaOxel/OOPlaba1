public class Matrix {
    final private int cols;
    final private int rows;
    final private int[][] temp;


    public Matrix () {
        this.rows=2;
        this.cols=2;
        this.temp=new int[2][2];
    }

    public Matrix (int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.temp = new int[rows][cols];
    }

    // Конструктор копирования: создаёт независимую копию матрицы other.
    // Массив копируется поэлементно, поэтому изменение оригинала не влияет на копию.
    public Matrix (Matrix other) {
        this.rows = other.rows;
        this.cols = other.cols;
        this.temp = new int[other.rows][other.cols];
        for (int i = 0; i < other.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                this.temp[i][j] = other.temp[i][j];
            }
        }
    }

    public int countCells () {
        return this.getCols()*this.getRows();
    }

    public int[][] getTemp() {
        return temp;
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public void setIJ (int i, int j, int value) {
        this.temp[i][j] = value;
    }

    public void print () {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.temp[i][j] + " ");
            }
            System.out.println();
        }
    }

}

