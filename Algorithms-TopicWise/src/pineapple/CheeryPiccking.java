package pineapple;

/**
 * In a N x N grid representing a field of cherries, each cell is one of three possible integers.
 * <p>
 * 0 means the cell is empty, so you can pass through;
 * 1 means the cell contains a cherry, that you can pick up and pass through;
 * -1 means the cell contains a thorn that blocks your way.
 * Your task is to collect maximum number of cherries possible by following the rules below:
 * <p>
 * Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
 * After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
 * When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
 * If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
 */
public class CheeryPiccking {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        cherryPickup(grid);
    }

    static int cherryCount = 0;
    public static int cherryPickup(int[][] grid) {
        int[][] pathDown = new int[][]{{0, 1}, {1, 0}}; //Right,left
        int[][] pathUp = new int[][]{{0, -1}, {-1, 0}};
        System.out.println(">>>>>>>>>>Valid Path=" + validPathforCherryPick(grid, pathDown, 0, 0, cherryCount) + " and cherrycount=" + cherryCount);

        return cherryCount;
    }

    private static boolean validPathforCherryPick(int[][] grid, int[][] pathDown, int i, int j, int cherryCount) {

        System.out.println("i=" + i + " j=" + j + " cherryCount=" + cherryCount);
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }

        for (int[] path : pathDown) {
            int x = i + path[0];
            int y = j + path[1];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && (grid[x][y] == 0 || grid[x][y] == 1)) { //boundry condtions
                System.out.println("Path Explored is : i=" + x + "y=" + y + " grid[x][y]=" + grid[x][y]);
                return validPathforCherryPick(grid, pathDown, x, y, cherryCount + grid[x][y]);
            }
        }

        return false;

    }
}
