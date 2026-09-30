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

}

