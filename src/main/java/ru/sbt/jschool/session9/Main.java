package ru.sbt.jschool.session9;

public class Main  {

    public static void main(String[] arg){

        Runnable[] tasks = {
                new Task1("Task1-1"),
                new Task2("Task2-2")
        };

        CallBack callBack = new CallBack();
        Context context = new ExecutionManagerImpl().execute(callBack, tasks);

        try{
            Thread.sleep(500);
            context.interrupt();
            Thread.sleep(100);
        }catch(Exception e){}

        while(!context.isFinished()){}

        System.out.println("Completed tasks count: " + context.getCompletedTaskCount());
        System.out.println("Interrupted tasks count: " + context.getInterruptedTaskCount());
        System.out.println("Failed tasks count: " + context.getFailedTaskCount());
    }
}