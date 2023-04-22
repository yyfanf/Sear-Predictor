package me.seat.fb.client;

import com.sun.tools.javac.Main;
import me.seat.fb.SeatPre;
import me.seat.fb.event.EventTarget;
import me.seat.fb.frames.MainFrame;

public class RunTick {
    @EventTarget
    public void onTick(){
        MainFrame.framePanel.repaint();
        MainFrame.framePanel.validate();
        SeatPre.mainFrame.repaint();
        SeatPre.mainFrame.validate();
    }
}
