package org.example.seminar1.runners;

public class DelayTaskRunner extends AbstractTaskRunner {
    public DelayTaskRunner(TaskRunner taskRunner) {
        super(taskRunner);
    }


    @Override
    public void executeOneTask() {
        try {
            Thread.sleep(3000);
            System.out.println("s-a executat un task cu întârziere");
            taskRunner.executeOneTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
