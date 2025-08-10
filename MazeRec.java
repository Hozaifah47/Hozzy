import java.util.*;

class MazeRec {
    public static void main(String args[]) {

        int i, j, r, c;

        MazeRec ob = new MazeRec();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        r = sc.nextInt();
        if (r < 1) {
            System.out.println("Invalid input!");
            return;

        }
        System.out.println("Enter the number of columns");
        c = sc.nextInt();
        if (c < 1) {
            System.out.println("Invalid input!");
            return;

        }
        int[][] ghost = new int[r][c];
        int[][] grid = new int[r][c];

        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                System.out
                        .println("Enter  *0 for path 1 for block* for (Row :" + (i + 1) + " Column :" + (j + 1) + " )");
                grid[i][j] = sc.nextInt();
                if (grid[i][j] < 0 || grid[i][j] > 1) {
                    System.out.println("Invalid input!");
                    return;
                }
            }
        }

        System.out.println("Enter row of end point");
        i = sc.nextInt();
        System.out.println("Enter Column of end point");
        j = sc.nextInt();

        if (grid[i][j] == 1) {

            System.out.println("Invalid Input!");
            return;

        }
        grid[i][j] = 3;

        System.out.println("Enter row of start point");
        i = sc.nextInt();
        System.out.println("Enter column of start point");
        j = sc.nextInt();

        if (grid[i][j] == 1) {

            System.out.println("Invalid Input!");
            return;

        }
        grid[i][j] = 2;

        System.out.println("Initial grid!");
        for (r = 0; r < grid.length; r++) {
            for (c = 0; c < grid[0].length; c++) {
                System.out.print(" " + grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");

        ob.recMaze(grid, ghost, i, j);

    }

    void recMaze(int[][] grid, int[][] ghost, int x, int y) {

        if (grid[x][y] == 3) {
            ghost[x][y] = 3;
            printPath(grid, ghost);
            ghost[x][y] = 0;
            return;
        }

        ghost[x][y] = 4;

        if (y - 1 >= 0 && (grid[x][y - 1] == 0 || grid[x][y - 1] == 3) && ghost[x][y - 1] == 0) {
            recMaze(grid, ghost, x, y - 1);
        }
        if (x - 1 >= 0 && (grid[x - 1][y] == 0 || grid[x - 1][y] == 3) && ghost[x - 1][y] == 0) {
            recMaze(grid, ghost, x - 1, y);
        }
        if (y + 1 < grid[0].length && (grid[x][y + 1] == 0 || grid[x][y + 1] == 3) && ghost[x][y + 1] == 0) {
            recMaze(grid, ghost, x, y + 1);
        }
        if (x + 1 < grid.length && (grid[x + 1][y] == 0 || grid[x + 1][y] == 3) && ghost[x + 1][y] == 0) {
            recMaze(grid, ghost, x + 1, y);
        }

        ghost[x][y] = 0;
    }

    void printPath(int[][] grid, int[][] ghost) {
        int r, c;

        System.out.println("Path found !");
        for (r = 0; r < grid.length; r++) {
            for (c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    System.out.print(" 2 ");
                } else if (grid[r][c] == 3) {
                    System.out.print(" 3 ");
                } else if (ghost[r][c] != 0) {
                    System.out.print(" " + ghost[r][c] + " ");
                } else {
                    System.out.print(" " + grid[r][c] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }
}