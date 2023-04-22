package me.seat.fb.client;

import me.seat.fb.frames.MainFrame;

public class Debugger {
    String name;
    public Debugger(String name){
        this.name = name;
    }

    public static void post(String info, Type type){
        System.out.println(String.format("[%s/%s]%s",Thread.currentThread().getName(),type.name(),info));
    }

    public static enum Type{
        SUCCESS,
        INFO,
        WARNING,
        ERROR
    }
}
