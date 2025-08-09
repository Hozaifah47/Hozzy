import java.util.*;

public class MineSweeperRec {
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

        int count = 0;
        if (x - 1 >= 0 && y - 1 >= 0 && grid[x - 1][y - 1] == 'X')
            count++;
        if (x - 1 >= 0 && grid[x - 1][y] == 'X')
            count++;
        if (x - 1 >= 0 && y + 1 < 10 && grid[x - 1][y + 1] == 'X')
            count++;
        if (y - 1 >= 0 && grid[x][y - 1] == 'X')
            count++;
        if (x + 1 < 10 && y - 1 >= 0 && grid[x + 1][y - 1] == 'X')
            count++;
        if (x + 1 < 10 && grid[x + 1][y] == 'X')
            count++;
        if (x + 1 < 10 && y + 1 < 10 && grid[x + 1][y + 1] == 'X')
            count++;
        if (y + 1 < 10 && grid[x][y + 1] == 'X')
            count++;

        return (char) (count + '0');
    }

    public static void main(String args[]) {
        char ghost[][] = new char[10][10];
        char grid[][] = new char[10][10];
        MineSweeperRec ob = new MineSweeperRec();
        ob.getGrid(ghost);
        int j, i;

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {

                grid[i][j] = '.';
                System.out.print(" " + ghost[i][j] + " ");
            }
            System.out.println();
        }

        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter x y coords");

        x = sc.nextInt();
        y = sc.nextInt();

        try {
            ghost = ob.openBoxRec(ghost, x, y);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.print(" " + ghost[i][j] + " ");
            }
            System.out.println();
        }

    }

    char[][] openBoxRec(char[][] arr, int x, int y) throws Exception {
        if ((x < 0 || x > 10 || y < 0 || y > 10) || arr[x][y] == 'X') {
            throw new Exception("Invalid!");

        }
        arr[x][y] = 'm';

        if (x - 1 >= 0 && y - 1 >= 0 && arr[x - 1][y - 1] == '0')
            openBoxRec(arr, x - 1, y - 1);
        if (x - 1 >= 0 && arr[x - 1][y] == '0')
            openBoxRec(arr, x - 1, y);
        if (x - 1 >= 0 && y + 1 < 10 && arr[x - 1][y + 1] == '0')
            openBoxRec(arr, x - 1, y + 1);
        if (y - 1 >= 0 && arr[x][y - 1] == '0')
            openBoxRec(arr, x, y - 1);
        if (x + 1 < 10 && y - 1 >= 0 && arr[x + 1][y - 1] == '0')
            openBoxRec(arr, x + 1, y - 1);
        if (x + 1 < 10 && arr[x + 1][y] == '0')
            openBoxRec(arr, x - 1, y);
        if (x + 1 < 10 && y + 1 < 10 && arr[x + 1][y + 1] == '0')
            openBoxRec(arr, x + 1, y + 1);
        if (y + 1 < 10 && arr[x][y + 1] == '0')
            openBoxRec(arr, x, y + 1);

        return arr;

    }
}
