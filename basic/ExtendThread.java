package basic;

/**
 * When thread is implemented we can not extend another class as only interface supports multiple inheritance.
 * For this reason implementing using runnable is preferable when we need thread as well as
 * implementing another class (Multiple inheritance).
 */
public class ExtendThread {
    public static void main(String[] args) {
        Thread four = new Thread4();
        Thread five = new Thread5();

        four.start();
        five.start();
    }
}

class Thread4 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Thread 4: " + i);
        }
    }
}

class Thread5 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Thread 5: " + i);
        }
    }
}