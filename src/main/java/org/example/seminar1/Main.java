package org.example.seminar1;

import org.example.seminar1.factories.Strategy;
import org.example.seminar1.models.Message;
import org.example.seminar1.models.MessageTask;
import org.example.seminar1.models.SortingTask;
import org.example.seminar1.models.Task;
import org.example.seminar1.runners.DelayTaskRunner;
import org.example.seminar1.runners.PrinterTaskRunner;
import org.example.seminar1.runners.StrategyTaskRunner;
import org.example.seminar1.runners.TaskRunner;
import org.example.seminar1.sorting.AbstractSorter;
import org.example.seminar1.sorting.SortingStrategy;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static Strategy strategy;
    public static void main(String[] args) {
        if(args.length == 0 ){
            System.out.println("program strategie [FIFO/LIFO]");
        }
        String str = args[0].toUpperCase();
        if(!str.equals(Strategy.FIFO.toString()) && !str.equals(Strategy.LIFO.toString())){
            System.out.println("program strategie [FIFO/LIFO]");
        }
        if(str.equals(Strategy.FIFO.toString())){
            strategy = Strategy.FIFO;
        }else{
            strategy = Strategy.LIFO;
        }
        testTaskRunner();

    }

    private static void testMessage() {
        Message message1 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task1 = new MessageTask("1", "d1", message1);

        Message message2 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task2 = new MessageTask("2", "d2", message2);

        Message message3 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task3 = new MessageTask("3", "d3", message3);

        Message message4 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task4 = new MessageTask("4", "d4", message4);

        Message message5 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task5 = new MessageTask("5", "d5", message5);

        List<Task> tasks = new LinkedList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);

        for (Task task : tasks) {
            System.out.println(task);
        }
    }
    
    private static void testTaskRunner() {
        Message message1 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task1 = new MessageTask("1", "d1", message1);

        Message message2 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task2 = new MessageTask("2", "d2", message2);

        Message message3 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task3 = new MessageTask("3", "d3", message3);

        Message message4 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task4 = new MessageTask("4", "d4", message4);

        Message message5 = new Message("hello", "mircea", "fenesan", LocalDateTime.now());
        Task task5 = new MessageTask("5", "d5", message5);

        List<Task> tasks = new LinkedList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);

        TaskRunner strategyTaskRunner = new StrategyTaskRunner(strategy);
        TaskRunner strategyTaskRunnerForPrinter = new StrategyTaskRunner(strategy);
        TaskRunner strategyTaskRunnerForDelay = new StrategyTaskRunner(strategy);
        TaskRunner printerTaskRunner = new PrinterTaskRunner(strategyTaskRunnerForPrinter);
        TaskRunner delayTaskRunner = new DelayTaskRunner(strategyTaskRunnerForDelay);

        /*
        Se adauga taskuri in ambele
         */
        for (Task task : tasks) {
            strategyTaskRunner.addTask(task);
            printerTaskRunner.addTask(task);
            delayTaskRunner.addTask(task);
        }
        System.out.println("executie cu strategy fara decorator:");
        strategyTaskRunner.executeAll();

        System.out.println("\nexecutie cu printer decorator:");
        printerTaskRunner.executeAll();

        System.out.println("\nexecutie cu intarzieri:");
        delayTaskRunner.executeAll();

        System.out.println("\nsortare:");
        int[] numbers = {3, 2, 1};
        Task sortingTask = new SortingTask("1", "bka", SortingStrategy.MERGESORT, numbers);
        sortingTask.execute();
    }
}
