package DynamicProgramming;

/**
 * Created by gyaneshwar on 23/03/2017.
 */
public class SquareInMatrixWith1 {


    public int[][] MaxSizeSquareMatrixWith1(int[][] arr) {

        int rows = arr.length;
        int columns = arr[0].length;
        int[][] newMatrix = new int[rows][columns];

        //fill the values to first column and first rows
        for (int i = 0; i < rows; i++) {
            newMatrix[i][0] = arr[i][0];
        }

        for (int j = 0; j < columns; j++) {
            newMatrix[0][j] = arr[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (arr[i][j] == 1)
                    newMatrix[i][j] = getMinimum(newMatrix[i][j - 1], newMatrix[i - 1][j], newMatrix[i - 1][j - 1])+1;
                else
                    newMatrix[i][j] = 0;
            }
        }
        return newMatrix;

    }

    private int getMinimum(int i, int i1, int i2) {
        int m = i;
        if (m > i1)
            m = i1;
        if (m > i2)
            m = i2;
        return m;
    }


    public void printMatrix(int[][] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                {
                        0, 1, 1, 0, 1
                },
                {
                        1, 1, 0, 1, 0
                },
                {
                        0, 1, 1, 1, 0
                },
                {
                        1, 1, 1, 1, 0
                },
                {
                        1, 1, 1, 1, 1
                },
                {
                        0, 0, 0, 0, 0
                }
        };

        SquareInMatrixWith1 squareInMatrixWith1 = new SquareInMatrixWith1();
        int[][] arr1 = squareInMatrixWith1.MaxSizeSquareMatrixWith1(arr);
        squareInMatrixWith1.printMatrix(arr1);
    }
}
