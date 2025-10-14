package basic;

/**
 * Daemon threads are background threads that runs as long as any other user thread is running
 * When all user threads are executed daemon thread will also be terminated
 */
public class DaemonUserThread {
    public static void main(String[] args) {
        Thread bg = new Thread(new DaemonThreadHelper());
        Thread user = new Thread(new UserThreadHelper());
        bg.setDaemon(true);
        bg.start();
        user.start();
    }
}

/**
 * This daemon thread will not run for 500 seconds
 * This is because after 5 seconds the user thread will be terminated
 * As soon is user thread is terminated the daemon thread will also be terminated by JVM
 */
class DaemonThreadHelper implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (count < 500) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon thread running.....");
        }
    }
}

class UserThreadHelper implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User thread execution completed");

    }
}