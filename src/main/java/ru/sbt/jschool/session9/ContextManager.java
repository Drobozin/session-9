package ru.sbt.jschool.session9;

public class ContextManager implements Context {

    private Context[] contextArr;

    public ContextManager(Context[] context){
        contextArr = context;
    }

    @Override
    public int getCompletedTaskCount() {
        int count = 0;
        for(int i=0; i<contextArr.length; i++){
            try {
                while(!contextArr[i].isFinished()){}
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
                while(!contextArr[i].isFinished()){}
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
                while(!contextArr[i].isFinished()){}
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