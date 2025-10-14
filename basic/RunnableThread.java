package basic;

/**
 * When implemented using Runnable the Thread class's constructor needs to be called
 * This is  to let runnable know what to run
 */
public class RunnableThread {
    public static void main(String[] args) {
        Thread one = new Thread(new Thread1());
        Thread two = new Thread(new Thread2());
        Thread three = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                System.out.println("Thread 3: " + i);
            }
        });
        one.start();
        two.start();
        three.start();
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Thread 1: " + i);
        }
    }
}


class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            System.out.println("Thread 2: " + i);
        }
    }
}