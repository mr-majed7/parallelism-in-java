package basic;

/**
 * When a program is started usually main method starts other threads
 * It is the parent thread from which other threads are spawned
 * With join we can halt the parent thread to wait for the execution of child thread to be completed
 */
public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        one.start();
        two.start();
        /**
         * Prints immediately after starting the threads.
         * The main thread runs concurrently with other threads,
         * so this message may appear before or between their outputs.
         * Thread scheduling is handled by the JVM and OS — order is not guaranteed.
         */
        System.out.println("Done executing threads");
        /**
         * Causes the main thread to wait until threads are finished executing.
         * After 'one' and 'two' completes, the main thread resumes and prints the next line.
         * This ensures that "Done executing threads" (below) appears only after
         * both threads has completed.
         */
        one.join();
        two.join();
        System.out.println("Done executing threads");

    }
}


