public class Task13 {
    public static void main(String[] args) {
        int size = 5;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1; // Главная диагональ
            array[i][size - i - 1] = 1; // Побочная диагональ
        }

        System.out.println("Массив:");
        printArray(array);
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
