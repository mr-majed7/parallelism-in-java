package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService provides a higher-level replacement for working directly with Thread objects.
 * It manages thread lifecycle, task scheduling, and simplifies concurrent execution.
 * In this example, only one thread is used to execute submitted tasks sequentially.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            for (int i = 0; i < 5; i++) {
                service.execute(new Task(i));
            }
        }
    }
}


class Task implements Runnable {
    private final int taskId;

    public Task(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id " + taskId + " is being executed by " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}