package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenskart on 26/02/2017.
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PathBetweenToCoordinate {

    private List<Point> path = new ArrayList<>();

    public boolean getPath(int x, int y) {
        Point p = new Point(x, y);
        boolean success = false;
        if (x == 0 && y == 0)
            return true;
        if (x >= 1 && isFree(x - 1, y)) {
            success = getPath(x - 1, y);
        }
        if (!success && y >= 1 && isFree(x, y - 1)) {
            success = getPath(x, y - 1);
        }
        if (success) {
            this.path.add(p);
        }
        return success;
    }

    private boolean isFree(int i, int y) {
        return true;
    }

    public void printPath() {
        for (Point s : this.path) {
            System.out.println(s.x + " : " + s.y);
        }
    }

    public boolean getPathDP() { //todo create a cache and to this
        return true;
    }

    public static void main(String[] args) {
        PathBetweenToCoordinate pathBetweenToCoordinate = new PathBetweenToCoordinate();
        pathBetweenToCoordinate.getPath(4, 3);
        pathBetweenToCoordinate.printPath();
    }

}


