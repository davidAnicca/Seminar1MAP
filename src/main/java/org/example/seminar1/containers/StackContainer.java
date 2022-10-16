package org.example.seminar1.containers;

import org.example.seminar1.models.Task;

import java.util.ArrayList;
import java.util.List;

public class StackContainer extends QueueStackContainer {

    @Override
    public Task remove() {
        return super.tasks.remove(size() - 1);
    }
}
