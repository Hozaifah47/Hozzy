import java.util.*;

class MineSweeperNew {

    public int randomIndex(int lb, int ub) {
        return (int) (Math.random() * (ub - lb + 1) + lb);
    }

    public String[][] minesAssigner(String[][] grid, String[][] grid2) {
        int i = 0, row, column;
        while (i < 20) {
            row = randomIndex(0, 8);
            column = randomIndex(0, 8);
            if (!grid[row][column].equals("X")) { // Check for overlap
                grid[row][column] = "X";
                grid2[row][column] = "X";

                i++;
            }
        }
        return grid;
    }

    public static boolean validCoord(String[][] grid, int x, int y) {
        if (x >= 10 || y >= 10 || x < 0 || y < 0) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[][] grid = new String[10][10];
        String[][] ghost = new String[10][10];
        boolean flag = true;

        int i, j;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                grid[i][j] = "1";
                ghost[i][j] = "1";
            }
        }
        MineSweeperNew ob = new MineSweeperNew();
        ob.minesAssigner(grid, ghost);

        System.out.println("Mines Assigned -->");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("Enter coordinates to open");
        System.out.print("X:");
        int x = sc.nextInt();
        System.out.print("Y:");
        int y = sc.nextInt();
        if (x >= 10 || y >= 10 || x < 0 || y < 0 || (grid[x][y] == "X")) {
            System.out.println("Invalid coords");
            return;

        }

        ghost[x][y] = "m";
        do {

            for (i = 0; i < 10; i++) {
                for (j = 0; j < 10; j++) {

                    if (ghost[i][j] == "m") {

                        ghost[i][j] = "c";

                        if (validCoord(ghost, i - 1, j - 1) && ghost[i - 1][j - 1] == "0") {
                            ghost[x - 1][y - 1] = "m";
                        }
                        if (validCoord(ghost, i - 1, j) && ghost[i - 1][j] == "0") {
                            ghost[i - 1][j] = "m";
                        }
                        if (validCoord(ghost, i - 1, j + 1) && ghost[i - 1][j + 1] == "0") {
                            ghost[i - 1][j + 1] = "m";
                        }
                        if (validCoord(ghost, i, j - 1) && ghost[i][j - 1] == "0") {
                            ghost[i][j - 1] = "m";
                        }
                        if (validCoord(ghost, i, j + 1) && ghost[i][j + 1] == "0") {
                            ghost[i][j + 1] = "m";
                        }
                        if (validCoord(ghost, i + 1, j - 1) && ghost[i + 1][j - 1] == "0") {
                            ghost[i + 1][j - 1] = "m";
                        }
                        if (validCoord(ghost, i + 1, j) && ghost[i + 1][j] == "0") {
                            ghost[i + 1][j] = "m";
                        }
                        if (validCoord(ghost, i + 1, j + 1) && ghost[i + 1][j + 1] == "0") {
                            ghost[i + 1][j + 1] = "m";
                        }

                    }
                }
            }

        } while (flag);

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                if (ghost[i][j] == "c") {
                    System.out.print(" 0 ");
                    continue;
                }
                System.out.print(" " + grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    boolean Marker()
}