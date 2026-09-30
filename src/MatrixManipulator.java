public class MatrixManipulator {
    Matrix matrix;

    public MatrixManipulator (Matrix matrix) {
        this.matrix=matrix;
    }


    private int[] to1DArray() {
        int total = this.matrix.countCells();
        int[] all = new int[total];
        int k = 0;
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                all[k] = matrix.getTemp()[i][j];
                k++;
            }
        }
        return all;
    }

    private int getDifferentCounts () {
        int[] all=this.to1DArray();
        int different = 0;
        int total = this.matrix.countCells();
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
        return different;
    }
    public float calculateAverage () {
        int total = this.matrix.countCells();
        return (float) total /this.getDifferentCounts();
    }

}
