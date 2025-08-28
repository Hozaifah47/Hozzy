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
        while (grid[x][y] != 3) {
            int random = (int) ((Math.random() * 4 + 1));
            // System.out.println(random);
            switch (random) {
                case 1:

                    if (isValid(x, y - 1) && grid[x][y - 1] != 4) {
                        System.out.println(random);
                        grid[x][y - 1] = 4;
                        y = y - 1;
                    }
                    break;
                case 2:

                    if (isValid(x - 1, y) && grid[x - 1][y] != 4) {
                        System.out.println(random);
                        grid[x - 1][y] = 4;
                        x = x - 1;
                    }
                    break;
                case 3:

                    if (isValid(x, y + 1) && grid[x][y + 1] != 4) {
                        System.out.println(random);
                        grid[x][y + 1] = 4;
                        y = y + 1;
                    }
                    break;
                case 4:
                    if (isValid(x + 1, y) && grid[x + 1][y] != 4) {
                        System.out.println(random);
                        grid[x + 1][y] = 4;
                        x = x + 1;
                    }
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

    static int[][] isValid(int x, int y) {
        int coords[][]=new int[4][2];
        int count;
        if()
        


    }
}
