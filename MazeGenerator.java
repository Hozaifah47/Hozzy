import java.util.*;

public class MazeGenerator {
    static int grid[][];

    public static void main(String[] args) {

        int r, c, x, y, x2, y2, i, j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows of the maze");
        r = sc.nextInt();
        System.out.println("Enter the cols of the maze");
        c = sc.nextInt();
        while (true) {
            grid = new int[r][c];
            x = (int) (Math.random() * r);
            y = (int) (Math.random() * c);
            x2 = (int) (Math.random() * r);
            y2 = (int) (Math.random() * c);

            grid[x][y] = 2;
            if (grid[x][y] != grid[x2][y2]) {
                grid[x2][y2] = 3;
                break;
            }
        }

        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                System.out.print(" " + grid[i][j] + " ");

            }
            System.out.println();
        }
    }

    static void pathFind(int cx, int cy, int px, int py) {
        if (cx < 0 || cy < 0 || cx >= grid.length || cy >= grid[0].length) {
            return;
        } // && is adjecent
        if (grid[cx][cy] == 4) {
            return;

        }
        if (grid[cx][cy] == 3) {

            System.out.println("Path found !");
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    System.out.print(" " + grid[r][c] + " ");
                }
                System.out.println();
            }
        }
        grid[px][py] = 4;
        if (cy - 1 != py && cx != px) {

            pathFind(cx, cy - 1, cx, cy);

        }

    }
}