import java.util.*;

class dateintersect {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int days[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int sd1, sm1, ed1, em1, sd2, sm2, ed2, em2;
        int day = 0, i;
        boolean flag = false;
        // first range
        System.out.println("enter first starting date");
        sd1 = sc.nextInt();
        System.out.println("enter first starting month");
        sm1 = sc.nextInt();
        System.out.println("enter first ending date");
        ed1 = sc.nextInt();
        System.out.println("enter first ending month");
        em1 = sc.nextInt();
        // second range
        System.out.println("enter second starting date");
        sd2 = sc.nextInt();
        System.out.println("enter second starting month");
        sm2 = sc.nextInt();
        System.out.println("enter second ending date");
        ed2 = sc.nextInt();
        System.out.println("enter second ending month");
        em2 = sc.nextInt();
        // applying conditions to remove false inputs
        if (sm1 > em1 || sm2 > em2) {
            System.out.println("enter the values correctly");
            return;
        }
        if (sm1 == em1 && sm2 == em2 && sm1 == sm2) {
            if (ed1 <= sd1 || ed2 <= sd2) {
                System.out.println("enter the values correctly");
                return;
            }
        }
        if (sm1 == em1 && ed1 <= sd1) {
            System.out.println("enter the values correctly");
            return;
        }
        if (sm2 == em2 && ed2 <= sd2) {
            System.out.println("enter the values correctly");
            return;
        }
        // now checking if intersecting or not
        if (sm2 < em1) {
            flag = true;
        }
        if (sm2 == em1 && sd2 < ed1) {
            flag = true;
        }
        if ((sm1 == em1 && sm2 == em2 && sm1 == sm2) && (sd2 < ed1)) {
            flag = true;
        }
        if (flag == true) {
            System.out.println("intersecting");
        } else {
            System.out.println("not intersecting");
            return;
        }
        // calculating the days in between
        if ((sm1 == em1 && sm2 == em2 && sm1 == sm2) || (em1 == sm2)) {
            day = ed1 - sd2;
        } else {
            day = days[sm2] - sd2;
            for (i = sm2 + 1; i < em1; i++) {
                day += days[i];
            }
            day += ed1;
        }
        System.out.println("number of days in between : " + day);

    }
}