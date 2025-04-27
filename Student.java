import java.util.*;

public class Student {

    public static void main(String args[]) {
        Student ob = new Student();
        String name[] = new String[50];
        int phy[] = new int[50];
        int chem[] = new int[50];
        int bio[] = new int[50];
        int math[] = new int[50];
        int avg[] = new int[50];
        int i, pos, high, a = 0, b = 0, c = 0, d = 0, f;
        Scanner sc = new Scanner(System.in);
        for (i = 0; i < name.length; i++) {

            System.out.println("Enter a name");
            name[i] = sc.nextLine();

            System.out.println("Enter the marks of physics (out of 100)");
            phy[i] = sc.nextInt();
            if (phy[i] > 100 && phy[i] < 0) {
                System.out.println("Invalid input!");
                return;
            }

            System.out.println("Enter the marks of chemistry(out of 100)");
            chem[i] = sc.nextInt();
            if (chem[i] > 100 && chem[i] < 0) {
                System.out.println("Invalid input!");
                return;
            }

            System.out.println("Enter the marks of biology(out of 100)");
            bio[i] = sc.nextInt();
            if (bio[i] > 100 && bio[i] < 0) {
                System.out.println("Invalid input!");
                return;
            }

            System.out.println("Enter the marks of maths(out of 100)");
            math[i] = sc.nextInt();
            if (math[i] > 100 && math[i] < 0) {
                System.out.println("Invalid input!");
                return;
            }

            sc.nextLine();

        }
        for (i = 0; i < avg.length; i++) {
            avg[i] = (phy[i] + chem[i] + bio[i] + math[i]) / 4;
        }

        // overall topper

        high = ob.highest(avg);

        pos = ob.indexFinder(avg, high);

        System.out.println(name[pos] + "highest average" + high + "%");

        // subject wise top physics

        high = ob.highest(phy);

        pos = ob.indexFinder(phy, high);

        System.out.println(name[pos] + "highest in physics" + high);

        // chemistry

        high = ob.highest(chem);

        pos = ob.indexFinder(chem, high);

        System.out.println(name[pos] + "highest in chemistry" + high);

        // biology

        high = ob.highest(bio);

        pos = ob.indexFinder(bio, high);

        System.out.println(name[pos] + "highest in biology" + high);

        // maths

        high = ob.highest(math);

        pos = ob.indexFinder(math, high);

        System.out.println(name[pos] + "highest in maths" + high);

        // count of grades

        for (i = 0; i < avg.length; i++) {
            if (avg[i] >= 90) {
                a++;
            } else if (avg[i] >= 80) {
                b++;
            } else if (avg[i] >= 60) {
                c++;
            } else if (avg[i] >= 40) {
                d++;
            }

        }
        f = 50 - (a + b + c + d);

        System.out.println("count of grades");
        System.out.print("A:" + a + " B:" + b + " C:" + c + " D:" + d + " F:" + f);

    }

    public int highest(int arr[]) {
        int highest = arr[0], i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > highest) {
                highest = arr[i];
            }
        }
        return highest;
    }

    public int indexFinder(int arr[], int num) {
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}