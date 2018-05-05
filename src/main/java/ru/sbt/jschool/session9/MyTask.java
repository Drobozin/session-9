package ru.sbt.jschool.session9;

public class MyTask {
    MyTask[] tasks;

    public MyTask(MyTask... arr) {
        tasks = arr;
        runs = new Runnable[ arr.length ];
        contexts = new Context[ arr.length ];
        fillArrays();
    }

    private void fillArrays() {
        for (int i = 0; i < tasks.length; i++) {
            runs[ i ] = (Runnable) tasks[ i ];
            contexts[ i ] = (Context) tasks[ i ];
        }
    }

    Runnable[] runs;
    Context[] contexts;

    public Context[] getContexts() {
        return contexts;
    }

    public Runnable[] getRuns() {
        return runs;
    }
}
