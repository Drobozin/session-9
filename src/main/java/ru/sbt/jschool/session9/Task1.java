package ru.sbt.jschool.session9;

public class Task1 extends MyTask implements Runnable, Context{
    public String name ;
    private int completedTaskCount;
    private int failedTaskCount;
    private int interruptedTaskCount;
    private boolean isFinished;

    public Task1(String name){
        this.name = name;
    }


    @Override
    public void run() {

        for(int i=0; i<10; i++){
            if(!isFinished) {
                try{
                    Thread.sleep(200);
                    if(i==1)
                        System.out.println(i/0);
                    System.out.println(name + " " + i);
                    completedTaskCount++;
                } catch (Exception e) {
                    failedTaskCount++;
                }
            }else{
                interruptedTaskCount++;
            }
        }
        isFinished = true;
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
