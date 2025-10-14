package basic;

/**
 * Threads can have priority from 1-10. The larger would have the more priority
 * By default threads have priority of 5
 * Threads are executed in FIFO order under normal circumstances
 */
public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());

    }
}
