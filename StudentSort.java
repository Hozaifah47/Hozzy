import java.util.*;

public class StudentSort {
    public static void main(String args[]) {
        String name[] = new String[20];
        String num[] = new String[20];
        int i, j;
        String temp, temp2;
        Scanner sc = new Scanner(System.in);
        for (i = 0; i < 20; i++) {
            System.out.println("Enter a name(count: " + i + ")");
            name[i] = sc.nextLine();
            System.out.println("Enter their phone number");
            num[i] = sc.nextLine();

        }
        for (i = 0; i < 20 - 1; i++) {
            for (j = 0; j < 20 - i - 1; j++) {
                if (name[j].compareToIgnoreCase(name[j + 1]) > 0) {
                    temp = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = temp;

                    temp2 = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp2;

                }
            }
        }
        for (i = 0; i < 20; i++) {
            System.out.println("Name : " + name[i]);
            System.out.println("phone number : " + num[i]);
        }
    }
}