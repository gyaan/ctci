package TransferWise;

/**
 * Created by Gyaneshwar on 20/03/2017.
 */
public class MyMain {

    public static void main(String[] args) {

        int[][] orchard = new int[3][3];
        orchard[0] = new int[]{4, 0, 1};
        orchard[1] = new int[]{1, 0, 0};
        orchard[2] = new int[]{0, 4, 0};

        CollectApple collectApple = new CollectApple();

        /*
         *Exercise 1 Example
         */
        System.out.println("Maximum Apple: " + collectApple.collectApples(orchard));

        /*
         *Exercise 2 Example
         */
        System.out.println("Maximum Apple using tokens: " + collectApple.collectApplesWithTokens(orchard, 2));
    }


}
