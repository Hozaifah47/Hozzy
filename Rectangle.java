import java.util.*;

public class Rectangle {
    public static void main(String args[]) {

        int rect1[] = new int[8];
        int rect2[] = new int[8];
        int i;
        boolean flag = false;
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
                System.out.println("Enter the X coordinate of the 2nd rectangle (count : edge " + (i / 2 + 1) + ")");
                rect2[i] = sc.nextInt();
            } else {
                System.out.println("Enter the Y coordinate of the 2nd rectangle (count : edge " + (i / 2 + 1) + ")");
                rect2[i] = sc.nextInt();
            }

        }
        for (i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                flag = checkPointInside(rect1[i], rect1[i + 1], rect2);
                if (flag) {
                    break;
                }

            }
        }
        if (flag == false) {
            for (i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    flag = checkPointInside(rect2[i], rect2[i + 1], rect1);
                    if (flag) {
                        break;
                    }

                }
            }

        }
        if (checkCrossOverlap(rect1, rect2) || checkCrossOverlap(rect2, rect1)) {
            flag = true;
        }
        if (flag) {
            System.out.println("Interscepting");
        } else {
            System.out.println("not interscepting");
        }

    }

    static boolean checkPointInside(int x, int y, int[] rect) {

        int minX, maxX, minY, maxY;
        minX = Math.min(Math.min(rect[0], rect[2]), Math.min(rect[4], rect[6]));
        maxX = Math.max(Math.max(rect[0], rect[2]), Math.max(rect[4], rect[6]));
        minY = Math.min(Math.min(rect[1], rect[3]), Math.min(rect[5], rect[7]));
        maxY = Math.max(Math.max(rect[1], rect[3]), Math.max(rect[5], rect[7]));

        return (x > minX && x < maxX && y > minY && y <= maxY) || (x >= minX && x < maxX && y > minY && y < maxY);

    }

    static boolean checkCrossOverlap(int[] rect1, int[] rect2) {
        int maxX1, maxY1, maxX2, maxY2;
        maxX1 = Math.min(Math.min(rect1[0], rect1[2]), Math.min(rect1[4], rect1[6]));
        maxX2 = Math.min(Math.min(rect2[0], rect2[2]), Math.min(rect2[4], rect2[6]));
        maxY1 = Math.max(Math.max(rect1[1], rect1[3]), Math.max(rect1[5], rect1[7]));
        maxY2 = Math.max(Math.max(rect2[1], rect2[3]), Math.max(rect2[5], rect2[7]));

        if (maxX1 > maxY1 || maxY2 > maxX2) {
            if ((rect2[1] < rect1[1] && rect2[3] < rect1[3] && rect2[5] < rect1[5] && rect2[7] < rect1[7])
                    && (rect2[0] > rect1[0] && rect2[6] > rect1[6] && rect2[2] < rect1[2] && rect2[4] < rect1[4])
                    || (rect1[0] > rect2[0] && rect1[6] > rect2[6] && rect1[2] < rect2[2] && rect1[4] < rect2[4])) {
                return true;

            }

        }
        return false;

    }
}
