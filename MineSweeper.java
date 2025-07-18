import java.util.*;

class MineSweeper {

    public int randomIndex(int lb, int ub) {
        return (int) (Math.random() * (ub - lb + 1) + lb);
    }

    public String[][] minesAssigner(String[][] grid) {
        int i = 0, row, column;
        while (i < 20) {
            row = randomIndex(0, 8);
            column = randomIndex(0, 8);
            if (!grid[row][column].equals("X")) { // Check for overlap
                grid[row][column] = "X";
                i++;
            }
        }
        return grid;
    }

    public static String[][] openBox(String[][] grid) {
        int i, j;
        int number;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                number = 0;

                if (grid[i][j].equals("X")) {
                    continue;
                }

                int[][] directions = {
                        { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 },
                        { 1, -1 }, { 1, 0 }, { 1, 1 }
                };

                for (int k = 0; k < directions.length; k++) {
                    int newRow = i + directions[k][0];
                    int newCol = j + directions[k][1];

                    if (validCoord(grid, newRow, newCol) && grid[newRow][newCol].equals("X")) {
                        number = 1;
                    }
                }

                grid[i][j] = String.valueOf(number);
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
        int i, j;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                grid[i][j] = "1";
            }
        }
        MineSweeper ob = new MineSweeper();
        ob.minesAssigner(grid);
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
        openBox(grid);
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(grid[i][j] + "   ");
            }
            System.out.println();
        }
    }
}