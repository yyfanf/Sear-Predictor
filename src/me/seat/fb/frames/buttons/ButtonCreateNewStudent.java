package me.seat.fb.frames.buttons;

import me.seat.fb.frames.render.FramePanel;
import me.seat.fb.student.TheClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCreateNewStudent extends JButton {
    public ButtonCreateNewStudent(){
        this.setText("Add");
        this.setBounds(150,500,75,35);
        this.setVisible(true);

        ActionListener ac = e -> {
            var name = JOptionPane.showInputDialog("Input name(输入名字)");
            if(name.length() > 3 || name.length() < 1 || name == null){
                JOptionPane.showMessageDialog(null,"Invalid name length!");
                return;
            }
            var locateLineX = JOptionPane.showInputDialog("Input LocateX(行)");
            if(locateLineX == null){
                JOptionPane.showMessageDialog(null,"Invalid Number!");
                return;
            }
            var locateLineY = JOptionPane.showInputDialog("Input LocateY(列)");
            if(locateLineX == null || locateLineY == null){
                JOptionPane.showMessageDialog(null,"Invalid Number!");
                return;
            }
            try {
                var interX = Integer.valueOf(locateLineX);
                var interY = Integer.valueOf(locateLineY);
                if(TheClass.isTheSeatEmpty(interX,interY)){
                    FramePanel.addNewStudent(name,interX - 1,interY);
                }
                FramePanel.getInsane().reFreshLabel();
            }catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null,"Invalid Number!");
                return;
            }
        };
        this.addActionListener(ac);
    }
}
