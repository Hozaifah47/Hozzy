import java.util.*;

public class EachRowColumn {
    public static void main(String[] args) {
        int row, col, i, j, rsum, csum, ch;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a the number of rows");
        row = sc.nextInt();
        System.out.println("Enter the number of columns");
        col = sc.nextInt();
        int[][] arr = new int[row][col];

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.println("Enter a number for row: " + (i + 1) + " and column: " + (j + 1));
                arr[i][j] = sc.nextInt();

            }
        }
        System.out.println("Enter 1 for sum of each of the rows");
        System.out.println("Enter 2 for sum of each of the columns");
        ch = sc.nextInt();

        if (ch != 1 && ch != 2) {
            System.out.println("Invalid input!");
        }

        if (ch == 1) {
            for (i = 0; i < row; i++) {
                rsum = 0;
                for (j = 0; j < col; j++) {
                    rsum = arr[i][j] + rsum;
                }
                System.out.println("sum of row:" + (i + 1) + " = " + rsum);

            }

        } else {
            for (i = 0; i < col; i++) {
                csum = 0;
                for (j = 0; j < row; j++) {
                    csum = arr[j][i] + csum;

                }
                System.out.println("sum of column:" + (i + 1) + " = " + csum);

            }

        }

    }
}