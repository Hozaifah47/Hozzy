import java.util.*;

public class Rectangle {
    public static void main(String args[]) {

        int rect1[] = new int[8];
        int rect2[] = new int[8];
        int i;
        Scanner sc = new Scanner(System.in);
        for (i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                System.out.println("Enter the X coordinate of the 1st rectangle (count : edge " + (i / 2 + 1) + ")");
                rect1[i] = sc.nextInt();
            } else {
                System.out.println("Enter the Y coordinate of the 1st rectangle (count : edge " + (i / 2 + 1) + ")");
                rect1[i] = sc.nextInt();
            }

        }
        for (i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                System.out.println("Enter the X coordinate of the 1st rectangle (count : edge " + (i / 2 + 1) + ")");
                rect2[i] = sc.nextInt();
            } else {
                System.out.println("Enter the Y coordinate of the 1st rectangle (count : edge " + (i / 2 + 1) + ")");
                rect2[i] = sc.nextInt();
            }

        }

    }

    boolean checkPointInside(int x, int y, int[] rect) {

        int minX, maxX, minY, maxY;
        minX = Math.min(Math.min(rect[0], rect[2]), Math.min(rect[4], rect[6]));
        maxX = Math.max(Math.max(rect[0], rect[2]), Math.max(rect[4], rect[6]));
        minY = Math.min(Math.min(rect[1], rect[3]), Math.min(rect[5], rect[7]));
        maxY = Math.max(Math.max(rect[1], rect[3]), Math.max(rect[5], rect[7]));

        return x > minX && x < maxX && y > minY && y < maxY;

    }
}
