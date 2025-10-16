package synchronization;

public class LockWithCustomObjects {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment1();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment2();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();

        System.out.println(counter1 + " ------ " + counter2);
    }

    /**
     * Now instead of using class level lock we are defining two separate lock objects
     */
    private static void increment1() {
        synchronized (lock1) {
            counter1++;
        }
    }

    private static void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }


}
