import java.util.*;

class DateRange {
    public static void main(String args[]) {
        int[] date1 = new int[4];
        int[] date2 = new int[4];
        int[] month=new int[12];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range of the 1st date");
        System.out.println("Enter the month");
        date1[0] = sc.nextInt();
        if (date1[0] < 1 || date1[0] > 31) {
            System.out.println("Invalid Input !");
            return;
        } // will optimise it later gotta add days cmd acroding to month cuz i dont wanna
          // see 30 days in feb
        System.out.println("Enter the Month");
        date1[1] = sc.nextInt();
        if (date1[1] < 1 || date1[1] > 12) {
            System.out.println("Invalid Input !");
            return;

        }

        System.out.println("Enter the day");
        date1[2] = sc.nextInt();
        if (date1[2] < 1 || date1[2] > 31) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the Month");
        date1[3] = sc.nextInt();
        if (date1[3] < 1 || date1[3] > 12) {
            System.out.println("Invalid Input !");
            return;
        }

        System.out.println("Enter the range of the 2nd date");
        System.out.println("Enter the day");
        date2[0] = sc.nextInt();
        if (date2[0] < 1 || date2[0] > 31) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the Month");
        date2[1] = sc.nextInt();
        if (date2[1] < 1 || date2[1] > 12) {
            System.out.println("Invalid Input !");
            return;

        }

        System.out.println("Enter the day");
        date2[2] = sc.nextInt();
        if (date2[2] < 1 || date2[2] > 31) {
            System.out.println("Invalid Input !");
            return;
        }
        System.out.println("Enter the Month");
        date2[3] = sc.nextInt();
        if (date2[3] < 1 || date2[3] > 12) {
            System.out.println("Invalid Input !");
            return;
        }
        for(i=0;i<12
        
        )

    }

}
