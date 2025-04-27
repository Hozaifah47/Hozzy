import java.util.*;

public class MarksSort {
    public static void main(String[] args) {
        int phy[] = new int[20];
        int math[] = new int[20];
        int chem[] = new int[20];
        String name[] = new String[20];
        int total[] = new int[20];
        int i, j, temp;
        String temp2;

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

            System.out.println("Enter the marks of maths(out of 100)");
            math[i] = sc.nextInt();
            if (math[i] > 100 && math[i] < 0) {
                System.out.println("Invalid input!");
                return;
            }

            sc.nextLine();
        }

        for (i = 0; i < total.length; i++) {
            total[i] = phy[i] + math[i] + chem[i];
        }
        for (i = 0; i < total.length - 1; i++) {
            for (j = 0; j <= total.length - i - 1; j++) {
                if (total[j] > total[j + 1]) {
                    temp = total[j];
                    total[j] = total[j + 1];
                    total[j + 1] = temp;

                    temp2 = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = temp2;

                }
            }
        }
        for (i = 0; i < name.length; i++) {
            System.out.println(name[i] + "scored a total of :" + total[i]);
        }

    }
}