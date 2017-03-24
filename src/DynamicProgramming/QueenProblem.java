package DynamicProgramming;

/**
 * Created by lenskart on 27/02/2017.
 */
public class QueenProblem {

    int columnForRow[] = new int[8];

    boolean check(int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(this.columnForRow[i] - this.columnForRow[row]);
            if (diff == 0 || diff == row - i) return false;
        }
        return true;
    }

    void placeQueen(int row) {
        if (row == 8) {
            //print board
            for (int row1 : this.columnForRow) {
                System.out.print(row1);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < 8; i++) {
            this.columnForRow[row] = i;
            if (check(row)) {
                placeQueen(row + 1);
            }
        }

    }

    public static void main(String[] args) {
        QueenProblem queenProblem = new QueenProblem();
        queenProblem.placeQueen(0);
    }

}
