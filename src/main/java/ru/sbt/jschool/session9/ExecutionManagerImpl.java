package ru.sbt.jschool.session9;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutionManagerImpl implements ExecutionManager{

    private List<Context> taskList = new ArrayList<>();

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {

        ExecutorService service = Executors.newCachedThreadPool();

        for(Runnable task : tasks){
            service.execute(task);
            taskList.add((Context)task);
        }

        service.execute(callback);
        service.shutdown();
        return new ContextManager(taskList.toArray(new Context[ taskList.size()]));
    }
}