import java.util.*;

public class TestFib {
    public static void main(String args[]) {
        RecFibo ob = new RecFibo();
        Scanner sc = new Scanner(System.in);
        int n, a = 0, b = 1;
        System.out.println("Enter a limit for fibonacci series :");
        n = sc.nextInt();
        ob.recursive(a, b, n);
    }
}

class RecFibo {
    void recursive(int a, int b, int n) {
        int c;
        if (n < 0) {
            return;
        }
        System.out.print(a + "   ");
        c = a + b;
        a = b;
        b = c;
        n = n - 1;
        recursive(a, b, n);
    }
}
