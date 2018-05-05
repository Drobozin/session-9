package ru.sbt.jschool.session9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CallBack implements Runnable {

    private List<Future<Object>> futureList = new ArrayList<>();
    private Context[] contextArr;

    public void setList(List<Future<Object>> futureList){
        this.futureList = futureList;
    }

    public CallBack(Context... context){
        this.contextArr = context;
    }

    public Context[] getContextArr(){
        return contextArr;
    }

    @Override
    public void run() {




        for(Future<Object> f : futureList){
            try{
                f.get();
            }
            catch(Exception e){}
        }


        /*for(Context context : contextArr) {
            System.out.println("Completed tasks count: " + context.getCompletedTaskCount());
            System.out.println("Interrupted tasks count: " + context.getInterruptedTaskCount());
            System.out.println("Failed tasks count: " + context.getFailedTaskCount());
        }*/


    }
}
