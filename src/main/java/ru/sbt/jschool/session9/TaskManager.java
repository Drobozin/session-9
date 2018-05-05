package ru.sbt.jschool.session9;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<TaskManager> taskList = new ArrayList<>();

    public void addTask(TaskManager task){
        taskList.add(task);


    }

    public Context[] getContexts() {
        Context[] conts = new Context[taskList.size()];
        for(int i = 0; i<conts.length; i++){
            conts[i] = (Context)taskList.get(i);
        }
        return conts;
    }

    public Runnable[] getRuns() {
        Runnable[] runs = new Runnable[taskList.size()];
        for(int i = 0; i<runs.length; i++){
            runs[i] = (Runnable)taskList.get(i);
        }
        return runs;
    }
}
