package DynamicProgramming;

/**
 * Created by lenskart on 26/02/2017.
 */
public class CountSteps {


    private int[] map = new int[100];
    /*
     * basic function
     */
    public static int countWays(int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public int countWaysDP(int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (this.map[n] > 0)
            return this.map[n];
        else {
            this.map[n] = countWaysDP(n - 1) + countWaysDP(n - 2) + countWaysDP(n - 3);
            return this.map[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
        CountSteps countSteps = new CountSteps();
        System.out.println(countSteps.countWaysDP(5));
    }
}
