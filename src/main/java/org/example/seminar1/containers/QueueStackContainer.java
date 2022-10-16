package org.example.seminar1.containers;

import org.example.seminar1.models.Task;

import java.util.ArrayList;
import java.util.List;

public abstract class QueueStackContainer implements Container{
    protected final List<Task> tasks = new ArrayList<>();
    @Override
    public abstract Task remove();

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public int size() {
        return tasks.size();
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }
}
