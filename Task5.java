public class Task5 {
    public static void main(String[] args) {
        int a = 10;
        int b = 15;
        boolean result = isSumInRange(a, b);
        System.out.println(result);
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
}
