import java.util.Arrays;

public class Canon {
    public static double[][] result(double[][] coeffic, int z, int x){
        double[][] result = new double[z][x];
        int numVariables = 2;
        int numConstraints = 3;

        //Нові змінні
        for (int i = 0; i < numConstraints; i++) {
            coeffic[i] = Arrays.copyOf(coeffic[i], numVariables + numConstraints + 1);
            coeffic[i][numVariables + i ] = 1;
        }
        //Заміна знаків змінних
        for (int i = 0; i < numConstraints; i++) {
            if (coeffic[i][numVariables] < 0) {
                for (int j = 0; j < numVariables + numConstraints + 1; j++) {
                    coeffic[i][j] *= -1;
                }
            }
        }
        for (int i = 0; i < numConstraints; i++) {
            for (int j = 0; j < numVariables + numConstraints + 1; j++) {
                result[i][j] = coeffic[i][j];
            }
            System.out.println();
        }
        return result;

    }
    public static void main(String[] args) {
        double[][] coeffic = {
                {1,   2, 1, 0, 0,  6},
                {2,   1, 0, 1, 0,  8},
                {-1,  1, 0, 0, 1,  4}
        };
        double[][] com = result(coeffic, coeffic.length, coeffic[0].length);

    }
}
