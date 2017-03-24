package TransferWise;

import java.util.PriorityQueue;

/**
 * Created by Gyaneshwar on 20/03/2017.
 */
public class CollectApple {

    private PriorityQueue priorityQueue;
    private int totalToken;
    private int[][] arr;
    private int[][] orchard;

    /*
     * Exercise 1
     */

    public int collectApples(int[][] orchard) {

        if (orchard.length < 1 || orchard[0].length < 1)
            return 0;

        this.arr = new int[orchard.length][orchard[0].length];
        //top right corner
        return recursiveFunction(orchard, 0, orchard[0].length - 1);
    }

    private int recursiveFunction(int[][] orchard, int i, int j) {

        if (i < 0 || j < 0 || i > orchard.length - 1 || j > orchard[0].length - 1) {
            return 0;
        } else if (i == orchard.length - 1 && j == 0) {
            return orchard[i][j];
        } else {
            if (this.arr[i][j] != 0)
                return this.arr[i][j];
            else {
                int f1 = recursiveFunction(orchard, i, j - 1);
                int f2 = recursiveFunction(orchard, i + 1, j);
                this.arr[i][j] = orchard[i][j] + max(f1, f2);
                return this.arr[i][j];
            }
        }
    }

     /*
     * Exercise 2
     */

    public int collectApplesWithTokens(int[][] orchard, int token) {

        this.arr = new int[orchard.length][orchard[0].length];
        this.totalToken = token;
        this.orchard = orchard;
        int a = recursiveFunction(orchard, 0, orchard[0].length - 1);

        //get the apple if we use token
        this.appleUsingToken(this.arr);

        //total apple = apple while moving + apple using token
        return a + this.sumOfHeap();
    }

    //get the apple count if we use token
    private void appleUsingToken(int[][] arr) {
        this.priorityQueue = new PriorityQueue();
        this.priorityQueue.add(this.orchard[0][arr[0].length - 1]); //add top right corner element
        recursiveFunction4(arr, 0, arr[0].length - 1);
    }

    /*
     *  Function to get top apple ripe
     */
    private void recursiveFunction4(int[][] arr, int i, int j) {

        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr[0].length - 1) {
            //out of array

        } else if (i == arr.length - 1 && j == 0) {
            //reached the destination
        } else {

            //looking for the  next node
            int v1 = Integer.MIN_VALUE;
            int v2 = Integer.MIN_VALUE;

            if (i <= arr.length - 1 && j - 1 >= 0)
                v1 = arr[i][j - 1];

            if (i + 1 < arr.length - 1 && j >= 0)
                v2 = arr[i + 1][j];


            if (v1 > v2) {
                updateHeap(this.orchard[i][j - 1]);
                recursiveFunction4(arr, i, j - 1);
            } else {
                updateHeap(this.orchard[i + 1][j]);
                recursiveFunction4(arr, i + 1, j);
            }
        }

    }


    /*
     * Utility functions
     */


    //update the min heap
    private void updateHeap(int value) {
        if (this.priorityQueue.size() < this.totalToken) {
            this.priorityQueue.add(value);
        } else if (Integer.parseInt(this.priorityQueue.peek().toString()) < value) {
            this.priorityQueue.poll();
            this.priorityQueue.add(value);
        }
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int sumOfHeap() {
        int sum = 0;
        for (Object a : this.priorityQueue) {
            sum = sum + Integer.parseInt(a.toString());
        }
        return sum;
    }
}
