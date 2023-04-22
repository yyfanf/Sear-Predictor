package me.seat.fb.frames.render;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Label extends JLabel{
    private int locateX;
    private int locateY;
    private int width;
    private int height;
    private String name;

    public void setLocateX(int locateX) {
        setBounds(locateX,this.locateY,this.width,this.height);
        this.locateX = locateX;
    }
    public void setLocateY(int locateY) {
        setBounds(this.locateX,locateY,this.width,this.height);
        this.locateY = locateY;
    }
    public void setLocate(int locateX,int locateY){
        setBounds(locateX,locateY,width,height);
        this.locateX = locateX;
        this.locateY = locateY;
    }

    public Label(String name, int x, int y, int width, int height){
        this.setText(name);
        this.setBounds(x,y,width,height);
        this.locateX = x;
        this.locateY = y;
        this.width = width;
        this.height = height;
        this.name = name;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                var name = JOptionPane.showInputDialog(null,"Input name(输入名字)");
                if(name.length() > 3){
                    JOptionPane.showInputDialog("InValid name!(invalid length)");
                    return;
                }
                setText(name);
                FramePanel.getInsane().reFreshLabel();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public int getLocateX() {
        return locateX;
    }

    public int getLocateY() {
        return locateY;
    }

    @Override
    public String getName() {
        return name;
    }
}
