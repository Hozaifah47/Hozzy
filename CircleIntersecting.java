import java.util.*;

class CircleIntersect {
    public static void main(String args[]) {
        double dist, r1, r2;
        int arr1[] = new int[2];
        int arr2[] = new int[2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the 1st circle");
        r1 = sc.nextDouble();
        if (r1 < 0.0) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter X the coordinates of its centre");
        arr1[0] = sc.nextInt();
        System.out.println("Enter Y the coordinates of its centre");
        arr1[1] = sc.nextInt();

        System.out.println("Enter the radius of the 2nd circle");
        r2 = sc.nextDouble();
        if (r2 < 0.0) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter X the coordinates of its centre");
        arr2[0] = sc.nextInt();
        System.out.println("Enter Y the coordinates of its centre");
        arr2[1] = sc.nextInt();

        dist = Math.sqrt((Math.pow(arr2[0] - arr1[0], 2) + Math.pow(arr2[1] - arr1[1], 2)));
        if (dist < r1 + r2) {
            System.out.println("the circles are intersecting");

        } else if (dist == r1 + r2) {
            System.out.println("The circles are touching");
        } else {
            System.out.println("The circles are not intersecting");
        }

    }

}