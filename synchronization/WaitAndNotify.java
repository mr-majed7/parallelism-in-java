package synchronization;

public class WaitAndNotify {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();
    }

    private static void one() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello From Method 1");
            LOCK.wait();
            System.out.println("Again from method 1");
        }
    }

    private static void two() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello From Method 2");
            LOCK.notify(); // Notify will take effect after the remaining code in the synchronized block is executed
            System.out.println("Again from method 2 after notifying");
        }
    }
}
