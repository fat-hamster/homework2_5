public class CalculateArray extends Thread {
    private float[] arr;

    public CalculateArray(float[] arr) {
        this.arr = new float[arr.length];
        this.arr = arr;
    }

    @Override
    public void run() {
        System.out.println("запуск потока " + this.getName());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f +
                    (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
    }
}
