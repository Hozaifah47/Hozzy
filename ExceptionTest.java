public class ExceptionTest {
    public static void main(String args[]) {

        int a = 10, b = 20;
        String name = "atif";
        int[] arr = { 1, 2, 3 };

        try {
            System.out.println(a / b);
            System.out.println(name.charAt(50));
            System.out.println(arr[arr.length] + 3);

        } catch (ArithmeticException ex) {
            System.out.println("bhai 0 mt dal");
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("bhai atif");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("bounds");
        } finally {
            System.out.println("finally im here");
        }

    }
}
