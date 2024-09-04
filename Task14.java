public class Task14 {
    public static void main(String[] args) {
        int len = 5;
        int initialValue = 10;
        int[] array = createArray(len, initialValue);

        System.out.println("Массив:");
        printArray(array);
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
