import java.util.*;

class MazeRec {
    static int[][] ghost;
    static int[][] grid;
    static int min;
    static int shortgrid[][];

    public static void main(String args[]) {

        int i, j, r, c;

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
        ghost = new int[r][c];
        grid = new int[r][c];
        shortgrid = new int[r][c];
        min = r * c;

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
        /*
         * if (i > grid.length || i < 0) {
         * System.out.println("Invalid input!");
         * return;
         * 
         * }
         */
        System.out.println("Enter Column of end point");
        j = sc.nextInt();

        /*
         * if (j > grid[0].length || j < 0) {
         * System.out.println("Invalid input!");
         * return;
         * }
         * 
         * if (grid[i][j] == 1) {
         * 
         * System.out.println("Invalid Input!");
         * return;
         * 
         * }
         */
        grid[i][j] = 3;

        System.out.println("Enter row of start point");
        i = sc.nextInt();
        /*
         * if (i > grid.length || i < 0) {
         * System.out.println("Invalid input!");
         * return;
         * 
         * }
         */
        System.out.println("Enter column of start point");
        j = sc.nextInt();

        /*
         * if (j > grid[0].length || j < 0) {
         * System.out.println("Invalid input!");
         * return;
         * }
         * 
         * if (grid[i][j] == 1) {
         * 
         * System.out.println("Invalid Input!");
         * return;
         * 
         * }
         */

        grid[i][j] = 2;

        System.out.println("Initial grid!");
        for (r = 0; r < grid.length; r++) {
            for (c = 0; c < grid[0].length; c++) {
                System.out.print(" " + grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------");

        try {
            recMaze(i, j, true, 0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }
        System.out.println("Shortest path ! (Length : " + min + " )");
        for (r = 0; r < grid.length; r++) {
            for (c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    System.out.print(" 2 ");
                } else if (grid[r][c] == 3) {
                    System.out.print(" 3 ");
                } else if (shortgrid[r][c] != 0) {
                    System.out.print(" " + shortgrid[r][c] + " ");
                } else {
                    System.out.print(" " + grid[r][c] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------");

    }

    static void recMaze(int x, int y, boolean check, int path) throws Exception {

        if (grid[x][y] == 3) {
            ghost[x][y] = 3;
            int r, c;
            if (path < min) {
                min = path;
                shortgrid = ghost;
                for (r = 0; r < grid.length; r++) {
                    for (c = 0; c < grid[0].length; c++) {
                        shortgrid[r][c] = ghost[r][c];
                    }
                }

            }
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
            ghost[x][y] = 0;
            return;
        }

        ghost[x][y] = 4;

        if (y - 1 >= 0 && (grid[x][y - 1] == 0 || grid[x][y - 1] == 3) && ghost[x][y - 1] == 0) {
            recMaze(x, y - 1, true, ++path);
        }
        if (x - 1 >= 0 && (grid[x - 1][y] == 0 || grid[x - 1][y] == 3) && ghost[x - 1][y] == 0) {
            recMaze(x - 1, y, true, ++path);
        }
        if (y + 1 < grid[0].length && (grid[x][y + 1] == 0 || grid[x][y + 1] == 3) && ghost[x][y + 1] == 0) {
            recMaze(x, y + 1, true, ++path);
        }
        if (x + 1 < grid.length && (grid[x + 1][y] == 0 || grid[x + 1][y] == 3) && ghost[x + 1][y] == 0) {
            recMaze(x + 1, y, true, ++path);
        }

        ghost[x][y] = 0;

    }

}