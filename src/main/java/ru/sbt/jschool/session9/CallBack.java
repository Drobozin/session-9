package ru.sbt.jschool.session9;

public class CallBack implements Runnable {

    @Override
    public void run() {
        System.out.println("Callback: DONE");
    }
}