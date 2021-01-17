public class Main {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr1 = new float[h];
    static float[] arr2 = new float[h];
    static long start;

    public static void main(String[] args) throws InterruptedException {
        init();

        first();
        System.out.println("=====================================");
        second();
    }

    private static void init() {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    private static void first() throws InterruptedException {
        CalculateArray simple = new CalculateArray(arr);
        System.out.println("Выполнение в 1 поток...");
        start = System.currentTimeMillis();
        simple.start();
        simple.join();
        System.out.println("Время выполнения в 1 поток: " + (System.currentTimeMillis() - start) + " миллисекунд.");
    }

    private static void second() throws InterruptedException {
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        CalculateArray one = new CalculateArray(arr1);
        CalculateArray two = new CalculateArray(arr2);
        System.out.println("Выполнение в 2 потока...");
        start = System.currentTimeMillis();
        one.start();
        two.start();
        one.join();
        two.join();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Время выполнения в 2 потока: " + (System.currentTimeMillis() - start) / 2 + " миллисекунд");
    }
}
