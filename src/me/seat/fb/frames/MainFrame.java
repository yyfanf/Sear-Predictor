package me.seat.fb.frames;

import me.seat.fb.SeatPre;
import me.seat.fb.frames.buttons.ButtonCreateNewStudent;
import me.seat.fb.frames.render.FramePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static boolean debugMode = false;
    public static FramePanel framePanel;

    public static MainFrame getInstance(){
        return SeatPre.mainFrame;
    }

    public MainFrame(boolean Debug){
        this.setDefaultCloseOperation(3);
        this.setSize(1000,800);
        framePanel = new FramePanel();
        this.setTitle("Seat Predictor by yyfanf             (I will be going to where next week?)");
        this.setResizable(false);
        //this.add(new ButtonCreateNewStudent());
        this.add(framePanel);
        framePanel.setVisible(true);
    }
}
