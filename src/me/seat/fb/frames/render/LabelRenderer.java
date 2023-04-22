package me.seat.fb.frames.render;

import me.seat.fb.SeatPre;
import me.seat.fb.frames.MainFrame;

import java.util.ArrayList;

public class LabelRenderer {
    public static ArrayList<Label> labels;
    private FramePanel mainPanel = MainFrame.framePanel;

    public LabelRenderer(){
        labels = new ArrayList<>();
    }


    public void addName(int x, int y, int width, int height, String name) {
        Label label = new Label(name, x, y, width, height);
        labels.add(label);
        FramePanel.getInsane().reFreshLabel();
    }

    public void removeName(String name) {
        for (Label label : labels) {
            if (label.getText().equals(name)) {
                mainPanel.remove(label);
                labels.remove(label);
                mainPanel.revalidate();
                mainPanel.repaint();
                FramePanel.getInsane().reFreshLabel();
                break;
            }
        }
    }
}
