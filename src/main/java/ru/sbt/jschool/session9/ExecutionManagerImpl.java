package ru.sbt.jschool.session9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutionManagerImpl implements ExecutionManager {
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {

        ExecutorService service = Executors.newCachedThreadPool();

        List<Future<Object>> futureList = new ArrayList<>();
        for(Runnable task : tasks){
            futureList.add(service.submit(task, null));
        }
        Context context = new ContextImpl();
        CallBack cb = (CallBack)callback;
        cb.setList(futureList);
        cb.setContext(context);
        service.execute(callback);

        service.shutdown();
        return context;
    }
}
