import java.util.*;

class MazeGen {
    static int[][] ghost = new int[10][10];

    public static int[][] isValidPath(int x, int y) throws Exception {
        int coords[][] = new int[4][2];

        if (x < 0 || x >= ghost.length || y < 0 || y >= ghost[0].length) {
            throw new Exception("Invalid coords");
        }
        int random = (int) (Math.random() * 4 + 1);
        switch (random) {
            case 1:
                if (ghost[x][y - 2] == 4 || ghost[x - 1][y - 1] == 4 || ghost[x + 1][y - 1] == 4) {
                    ghost[x][y - 1] = 9;

                }
                if (ghost[x][y - 1] == 0) {
                    coords[0][0] = x;
                    coords[0][1] = y - 1;
                }

                break;
            case 2:
                if (ghost[x - 2][y] == 4 || ghost[x - 1][y - 1] == 4 || ghost[x - 1][y + 1] == 4) {
                    ghost[x - 1][y] = 9;

                }
                if (ghost[x - 1][y] == 0) {
                    coords[1][0] = x - 1;
                    coords[1][1] = y;
                }
                break;
            case 3:
                if (ghost[x][y + 2] == 4 || ghost[x - 1][y + 1] == 4 || ghost[x + 2][y + 2] == 4) {
                    ghost[x][y + 1] = 9;

                }
                if (ghost[x][y + 1] == 0) {
                    coords[2][0] = x;
                    coords[2][1] = y + 1;
                }
                break;
            case 4:
                if (ghost[x + 2][y] == 4 || ghost[x + 1][y - 1] == 4 || ghost[x + 1][y + 1] == 4) {
                    ghost[x + 1][y] = 9;

                }
                if (ghost[x + 1][y] == 0) {
                    coords[3][0] = x + 1;
                    coords[3][1] = y;
                }

                break;
        }

        return coords;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int r, c, sx, sy, ex, ey, i, j;
        // System.out.println("Enter rows");
        r = 10;
        // System.out.println("Enter columns");
        c = 10;
        int ghost[][] = new int[r][c];
        while (true) {
            sx = (int) (Math.random() * r);
            sy = (int) (Math.random() * c);
            ex = (int) (Math.random() * r);
            ey = (int) (Math.random() * c);
            ghost[sx][sy] = 2;

            if (ghost[sx][sy] != ghost[ex][ey]) {
                ghost[ex][ey] = 3;
                break;
            }
        }
        System.out.println("start points=" + sx + sy + " end points=" + ex + ey);
        int[][] atiff;
        for (i = 0; i < 4; i++) {
            try {
                atiff = isValidPath(sx, sy);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }
            for (j = 0; j < 2; j++) {
                System.out.print(atiff[i][j] + " ");
            }
            System.out.println();
        }

    }
}