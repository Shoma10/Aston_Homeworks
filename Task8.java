public class Task8 {
    public static void main(String[] args) {
        printStringMultipleTimes("Hello, World!", 4);
    }

    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }
}
