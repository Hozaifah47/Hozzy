import java.util.*;

public class MineSweep {

    public static void main(String args[]) {

        MineSweep ob = new MineSweep();
        char grid[][] = new char[10][10];
        char ghost[][] = new char[10][10];
        int i, j, x, y, row, col;
        int m = 1, c = 0;

        grid = ob.getGrid(grid);
        ghost = grid;

        Scanner sc = new Scanner(System.in);
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(" " + grid[i][j] + " ");
            }
            System.out.println();
        }
        for (i = 0; i < 100; i++) {
            row = i / 10;
            col = i % 10;
            if (ob.checkPoint(grid, row, col) == '0') {
                grid[row][col] = '0';
            }
        }

        System.out.println("Enter X coordinate of a point");
        x = sc.nextInt();
        if (x < 1 || x > 9) {
            System.out.println("Invalid Input!");
            return;

        }
        System.out.println("Enter Y coordinate of a point");
        y = sc.nextInt();
        if (y < 1 || y > 9) {
            System.out.println("Invalid Input!");
            return;

        }

        ghost[x][y] = 'm';

        do {
            for (i = 0; i < 100; i++) {
                row = i / 10;
                col = i % 10;
                if (ghost[row][col] == 'c') {
                    c++;

                }

                if (ghost[row][col] == 'm') {

                    ghost[row][col] = 'c';

                    if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] == '0')
                        ghost[x - 1][y - 1] = 'm';
                    if (x - 1 >= 0 && grid[x - 1][y] == 'X')
                        ghost[x - 1][y] = 'm';
                    if (x - 1 >= 0 && y + 1 < 10 && grid[x - 1][y + 1] == '0')
                        ghost[x - 1][y + 1] = 'm';
                    if (y - 1 >= 0 && grid[x][y - 1] == 'X')
                        ghost[x][y - 1] = 'm';
                    if (x + 1 < 10 && y - 1 >= 0 && grid[x + 1][y - 1] == '0')
                        ghost[x + 1][y - 1] = 'm';
                    if (x + 1 < 10 && grid[x + 1][y] == 'X')
                        ghost[x + 1][y] = 'm';
                    if (x + 1 < 10 && y + 1 < 10 && grid[x + 1][y + 1] == '0')
                        ghost[x + 1][y + 1] = 'm';
                    if (y + 1 < 10 && grid[x][y + 1] == 'X')
                        ghost[x][y + 1] = 'm';

                }
            }
        } while (m != c);

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(" " + ghost[i][j] + " ");
            }
            System.out.println();
        }

    }

    char[][] getGrid(char grid[][]) {

        int bomb[] = new int[40];
        int i, row, col;
        for (i = 0; i < 40; i++) {
            bomb[i] = (int) (Math.random() * (9));

        }
        for (i = 0; i < 40; i += 2) {

            grid[bomb[i]][bomb[i + 1]] = 'X';

        }
        for (i = 0; i < 100; i++) {
            row = i / 10;
            col = i % 10;
            if (grid[row][col] != 'X') {
                grid[row][col] = checkPoint(grid, row, col);
            }

        }
        return grid;

    }

    char checkPoint(char grid[][], int x, int y) {

        char count = '0';
        if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] == 'X')
            return '1';
        if (x - 1 >= 0 && grid[x - 1][y] == 'X')
            return '1';
        if (x - 1 >= 0 && y + 1 < 10 && grid[x - 1][y + 1] == 'X')
            return '1';
        if (y - 1 >= 0 && grid[x][y - 1] == 'X')
            return '1';
        if (x + 1 < 10 && y - 1 >= 0 && grid[x + 1][y - 1] == 'X')
            return '1';
        if (x + 1 < 10 && grid[x + 1][y] == 'X')
            return '1';
        if (x + 1 < 10 && y + 1 < 10 && grid[x + 1][y + 1] == 'X')
            return '1';
        if (y + 1 < 10 && grid[x][y + 1] == 'X')
            return '1';

        return count;
    }
}
