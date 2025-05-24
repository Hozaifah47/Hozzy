import java.util.*;

class RemoveDigit {
    public static int remove0(int num, int position) {
        int c = 0;
        int temp = num;
        while (temp != 0) {
            temp /= 10;
            c++;
        }
        temp = (int) (num / Math.pow(10, c - position));
        temp = temp % 10;
        temp = (int) (temp * Math.pow(10, c - position));
        num = num - temp;
        return num;
    }

    public static int removeEntirely(int num, int position) {
        int c = 0;
        int temp = num;
        while (temp != 0) {
            temp /= 10;
            c++;
        }
        temp = (int) (num / Math.pow(10, c - position));
        temp = temp / 10;
        temp = (int) (temp * Math.pow(10, position - 1));
        num = temp + (int) (num % (Math.pow(10, position - 1)));
        return num;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, position;
        System.out.print("Enter number : ");
        num = sc.nextInt();
        System.out.print("Enter position : ");
        position = sc.nextInt();
        System.out.println(remove0(num, position));
        System.out.println(removeEntirely(num, position));
    }
}