package ru.sbt.jschool.session9;



public class Main  {



    public static void main(String[] arg){
        TaskManager taskManager = new TaskManager();

        taskManager.addTask(new Task1("Task1-1"));
        taskManager.addTask(new Task1("Task1-2"));
        taskManager.addTask(new Task2("Task2-3"));
        taskManager.addTask(new Task2("Task2-4"));


        ExecutionManager ex = new ExecutionManagerImpl();
        CallBack callBack = new CallBack(taskManager.getContexts());


        Context contextManager = ex.execute(callBack, taskManager.getRuns());
        try{
            Thread.sleep(800);
        }catch(Exception e){}
        contextManager.interrupt();

        while(!contextManager.isFinished()){
            try{
                Thread.sleep(10);

            }catch(Exception e){}
        }

        System.out.println("Completed tasks count: " + contextManager.getCompletedTaskCount());
        System.out.println("Interrupted tasks count: " + contextManager.getInterruptedTaskCount());
        System.out.println("Failed tasks count: " + contextManager.getFailedTaskCount());



    }
}
