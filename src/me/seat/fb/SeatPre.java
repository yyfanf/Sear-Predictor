package me.seat.fb;

import me.seat.fb.client.Client;
import me.seat.fb.client.RunTick;
import me.seat.fb.event.EventManager;
import me.seat.fb.frames.MainFrame;
import me.seat.fb.frames.render.LabelRenderer;
import me.seat.fb.student.TheClass;

public class SeatPre {
    private static SeatPre seatPre;
    public static MainFrame mainFrame;
    private RunTick runTick;
    public static LabelRenderer labelRenderer;
    public static TheClass classMain;

    public static SeatPre getInstance() {
        return seatPre;
    }

    public static void main(String[] args) {
        seatPre = new SeatPre();
        mainFrame = new MainFrame(false);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(3);
        getInstance().postInit();
    }

    public void postInit(){
        runTick = new RunTick();
        new Client().start();
        EventManager.getInstance().register(runTick);
        labelRenderer = new LabelRenderer();
        classMain = new TheClass();
    }
}
