package me.seat.fb.student;

import me.seat.fb.SeatPre;
import me.seat.fb.frames.render.FramePanel;
import me.seat.fb.frames.render.Label;
import me.seat.fb.frames.render.LabelRenderer;

import java.util.HashMap;
import java.util.Map;

public class TheClass {
    private int lineX = 5;
    private int lineY = 7;

    private Map<String,Integer[]> classStudents;

    public int getLineX() {
        return lineX;
    }

    public int getLineY() {
        return lineY;
    }

    public void setLineX(int lineX) {
        this.lineX = lineX;
    }

    public void setLineY(int lineY) {
        this.lineY = lineY;
    }

    public void putStudentMap(String name, int lineX, int lineY){
        this.classStudents.put(name,new Integer[]{lineX,lineY});
    }

    public Map<String, Integer[]> getClassStudents() {
        return classStudents;
    }

    public static TheClass getInstance(){
        return SeatPre.classMain;
    }

    public TheClass(){
        classStudents = new HashMap<>();
    }

    public static boolean isTheSeatEmpty(int locateX,int locateY){
        int[] var = new int[2];
        var[0] = locateX;
        var[1] = locateY;

        for (Integer[] inter : TheClass.getInstance().getClassStudents().values()){
            if(inter[0] == var[0] || inter[1] == var[1]){
                return false;
            }
        }
        return true;
    }

    public static int[] getSeatPos(int LineX, int LineY){
        int[] var = new int[2];
        var[0] = 313 + (LineX * 70);
        var[1] = 663 - (LineY * 50);
        return var;
    }

    public static Integer[] getStudentClassLocate(String name){
        var flag1 = TheClass.getInstance().classStudents;
        for (String n : TheClass.getInstance().classStudents.keySet()){
            if(n.equalsIgnoreCase(name)){
                return flag1.get(n);
            }
        }
        return null;
    }

    public static Integer[] getStudentProgramLocate(String name){
        for (Label l : LabelRenderer.labels){
            if(l.getName().equalsIgnoreCase(name)){
                Integer[] integers = new Integer[2];
                integers[0] = l.getLocateX();
                integers[1] = l.getLocateY();
                return integers;
            }
        }
        return null;
    }

    public static void setStudentClassLocate(String name,int lineX,int lineY){
        for (Label l : LabelRenderer.labels){
            if(l.getName().equalsIgnoreCase(name)){
                l.setLocate(lineX,lineY);
                TheClass.getInstance().classStudents.replace(name,new Integer[]{lineX,lineY});
                FramePanel.getInsane().reFreshLabel();
                return;
            }
        }
    }


}
