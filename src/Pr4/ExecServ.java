package Pr4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ExecServ {
    private final int threadsNum;
    private final Queue<Runnable> tasks;
    private final List<WorkThread> threads;
    private volatile boolean shut;

    public ExecServ(int threadsNum) {
        this.threadsNum = threadsNum;
        tasks = new LinkedList<>();
        threads = new ArrayList<>();
        shut = false;

        for (int i = 0; i < threadsNum; i++) {
            WorkThread th = new WorkThread();
            th.start();
            threads.add(th);
        }
    }

    public void submit(Runnable task) {
        if (shut) {
            throw new IllegalStateException("ExecutorService has been shutdown");
        }
        synchronized (tasks) {
            tasks.offer(task);
            tasks.notify(); //напоминание для нового потока (есть таск)
        }
    }

    public void shutdown() {
        shut = true;
        for (WorkThread th : threads) {
            th.interrupt();
        }
    }
    private class WorkThread extends Thread {
        @Override
        public void run() {
            while (!shut) {
                Runnable task;
                synchronized (tasks) {
                    while (tasks.isEmpty() && !shut) {
                        try {
                            tasks.wait();

                        }catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    task = tasks.poll();
                }
                if (task != null) {
                    try {
                        task.run();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        ExecServ e = new ExecServ(3);
        e.submit(() -> System.out.println("Task 1 executed"));
        e.submit(() -> System.out.println("Task 2 executed"));
        e.submit(() -> System.out.println("Task 3 executed"));
        e.submit(() -> System.out.println("Task 4 executed"));
        e.shutdown();
    }
}
