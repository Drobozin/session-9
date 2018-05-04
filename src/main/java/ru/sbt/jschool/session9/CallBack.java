package ru.sbt.jschool.session9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class CallBack implements Runnable {

    private List<Future<Object>> futureList = new ArrayList<>();
    private Context context;

    public void setList(List<Future<Object>> futureList){
        this.futureList = futureList;
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public void run() {


        int count = 0;

        while(count< futureList.size()){
            for(Future<Object> f : futureList) {
                if ( f.isDone() && count < futureList.size()) {
                    count++;
                    ((ContextImpl) context).incrCompletedTaskCount();
                }
            }
        }



        context.interrupt();


    }
}
