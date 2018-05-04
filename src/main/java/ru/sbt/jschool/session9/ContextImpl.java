package ru.sbt.jschool.session9;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class ContextImpl implements Context {
    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;
    private boolean isFinished;


    public void incrCompletedTaskCount(){
        completedTaskCount++;
    }
    public void incrFailedTaskCount(){
        failedTaskCount++;
    }

    public void incrInterruptedTaskCount(){
        interruptedTaskCount++;
    }


    @Override
    public int getCompletedTaskCount() {
        return completedTaskCount;
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return interruptedTaskCount;
    }

    @Override
    public void interrupt() {
        isFinished = true;

    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
