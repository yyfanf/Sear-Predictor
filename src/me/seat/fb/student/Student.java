package me.seat.fb.student;

import me.seat.fb.frames.render.Label;

public class Student{


    public Student(String name,int lineX,int lineY) {
        TheClass.getInstance().getClassStudents().put(name,new Integer[]{lineX,lineY});
    }
}
