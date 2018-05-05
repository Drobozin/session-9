package ru.sbt.jschool.session9;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class ContextManager implements Context {

    private Context[] contextArr;
    private List<Future<Object>> futureList;

    public ContextManager(Context[] context, List<Future<Object>> list){
        contextArr = context;
        futureList = list;
    }





    @Override
    public int getCompletedTaskCount() {
        int count = 0;
        for(int i=0; i<contextArr.length; i++){
            try {
                futureList.get(i).get();
                count += contextArr[ i ].getCompletedTaskCount();
            }catch(Exception e){}
        }
        return count;
    }

    @Override
    public int getFailedTaskCount() {
        int count = 0;
        for(int i=0; i<contextArr.length; i++){
            try {
                futureList.get(i).get();
                count += contextArr[ i ].getFailedTaskCount();
            }catch(Exception e){}
        }
        return count;
    }

    @Override
    public int getInterruptedTaskCount() {
        int count = 0;
        for(int i=0; i<contextArr.length; i++){
            try {
                futureList.get(i).get();
                count += contextArr[ i ].getInterruptedTaskCount();
            }catch(Exception e){}
        }
        return count;
    }

    @Override
    public void interrupt() {
        for(Context context : contextArr){
            context.interrupt();
        }

    }

    @Override
    public boolean isFinished() {
        int count = 0;
        while(count < contextArr.length && contextArr[count].isFinished()){
            count++;
        }
        if(count == contextArr.length)
            return true;

        return false;
    }
}
