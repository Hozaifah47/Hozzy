import java.util.*;

class DateRange {
    public static void main(String args[]) {
        int[] date1 = new int[4];
        int[] date2 = new int[4];
        int[] month = new int[12];
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range of the 1st date");
        System.out.println("Enter the month");
        date1[0] = sc.nextInt();
        if (date1[0] < 1 || date1[0] > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        date1[1] = sc.nextInt();
        if (date1[1] < 1 || date1[1] >= days[date1[0] - 1]) {
            System.out.println("Invalid Input !");
            return;

        }

        System.out.println("Enter the month");
        date1[2] = sc.nextInt();
        if (date1[2] < 1 || date1[2] > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        date1[3] = sc.nextInt();
        if (date1[3] < 1 || date1[3] >= days[date1[2] - 1]) {
            System.out.println("Invalid Input !");
            return;

        }

        System.out.println("Enter the range of the 2nd date");
        System.out.println("Enter the day");
        date2[0] = sc.nextInt();
        if (date2[0] < 1 || date2[0] > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        date2[1] = sc.nextInt();
        if (date2[1] < 1 || date2[1] >= days[date2[0] - 1]) {
            System.out.println("Invalid Input !");
            return;

        }

        System.out.println("Enter the month");
        date2[2] = sc.nextInt();
        if (date2[2] < 1 || date2[2] > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the day");
        date2[3] = sc.nextInt();
        if (date2[3] < 1 || date1[3] >= days[date1[2] - 1]) {
            System.out.println("Invalid Input !");
            return;

        }

    }

    isDateOverlap(int date1[],int date2[]){
        
    }

}
