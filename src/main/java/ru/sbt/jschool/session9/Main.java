package ru.sbt.jschool.session9;

public class Main  {
    public static void main(String[] arg){
        Task t1 = new Task("Task 1");
        Task t2 = new Task("Task 2");

        ExecutionManager ex = new ExecutionManagerImpl();
        Context context = ex.execute(new CallBack(), t1,t2);

        while(!context.isFinished()){
            try{
                Thread.sleep(1);
            }catch(Exception e){}

        }
        System.out.println("Completed count "+context.getCompletedTaskCount());
        System.out.println("Interrupted Count "+context.getInterruptedTaskCount());


    }
}
