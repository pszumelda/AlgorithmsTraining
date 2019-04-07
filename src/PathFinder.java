import java.util.ArrayList;
import java.util.List;

public class PathFinder {

    static boolean[][] map = new boolean[][]{
            {true,false,false,true,false},
            {true,false,false,true,true},
            {true,true,true,false,false},
            {true,false,true,false,false},
            {false,false,true,true,true}};


    public static void main(String[] args) {
        /*Find path from top-left to bottom-right
                Can move only right and down*/
        PathFinder pathFinder = new PathFinder();
        List<Point> path = pathFinder.findPath(map);
        for(Point point : path)
            System.out.print("row: " + point.row + " col: " + point.col + "\n");
    }

    class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public List<Point> findPath(boolean[][] map) {
        List<Point> path = new ArrayList<>();
        if (findPath(map, map.length - 1, map[map.length - 1].length - 1, path))
            return path;
        return null;
    }

    private boolean findPath(boolean[][] map, int row, int col, List<Point> path) {
        if (row < 0 || col < 0 || !map[row][col]) return false;
        boolean isInOrigin = row == 0 && col == 0;
        if (isInOrigin || findPath(map, row - 1, col, path) || findPath(map, row, col - 1, path)){
            path.add(new Point(row, col));
            return true;
        }
        return false;
    }

}
