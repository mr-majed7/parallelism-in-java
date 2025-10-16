package synchronization;

/**
 * When multiple threads are updating or using the same resources as expected race condition would occur
 * Java synchronize handles it by allowing only one thread to access the resource
 */
public class Synchornization {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        one.start();
        two.start();
        one.join();
        two.join();

        System.out.println(counter);
    }

    /**
     * A lock is applied to the method with synchronized key word
     * It is released when a thread finishes with the task
     * But the issue is it would acquire the class level block
     * So it would also block other codes that do not necessarily needs synchronization
     */
    private synchronized static void increment() {
        counter++;
    }
}
