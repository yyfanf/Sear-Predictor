package me.seat.fb.frames.render;

import me.seat.fb.frames.MainFrame;
import me.seat.fb.frames.buttons.ButtonCreateNewStudent;
import me.seat.fb.student.TheClass;
import me.seat.fb.util.ListUtil;

import javax.swing.*;
import java.awt.*;

public class FramePanel extends JPanel {
    public static Graphics2D g2d = null;

    public FramePanel(){
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.add(new ButtonCreateNewStudent());
        //JLabel jLabel = new JLabel("ssb");
        //jLabel.setBounds(313 + (5 * 70),663 - (1 * 50),100,20);
        //this.add(jLabel);
    }
    public static FramePanel getInsane(){
        return MainFrame.framePanel;
    }

    public static boolean g2dNotNull(){
        return (g2d != null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.g2d = (Graphics2D) g;


        Graphics2D g2d = (Graphics2D) g;

        g2d.setFont(new Font("微软雅黑",1,30));

        g2d.drawString("Seats",430,100);
        ((Graphics2D) g).setStroke(new BasicStroke(3f));
        //draw seats(Line)
        var lX = TheClass.getInstance().getLineX();
        var lY = TheClass.getInstance().getLineY();
        var fS = lX * lY;
        //g.drawLine(350,600,350,300);
        g2d.drawLine(300,650,300,650 - (lY * 50));
        g2d.drawLine(300,650,300 + (lX * 70),650);
        g2d.drawLine(300 + (lX * 70),650,300 + (lX * 70),650 - (lY * 50));
        for (int var = 1;var <= lY;var++){
            var fY = 650 - (var * 50);
            var fX = 300 + (lX * 70);
            g2d.drawLine(300, fY,fX,fY);
        }
        for (int var = 1;var <= lX;var++){
            var fX = 300 + (var * 70);
            g2d.drawLine(fX,650,fX,650 - (lY * 50));
        }
        //draw seats step 2


    }


    public void reFreshLabel(){
        for (Component com : this.getComponents()){
            if(com instanceof JLabel){
                remove(com);
            }
        }
        for (Label label : LabelRenderer.labels){
            this.add(label);
            //draw seats(name)


            label.setVisible(true);
        }
        validate();
        repaint();
    }

    public static void addNewStudent(String name,int lineX,int lineY){
        TheClass.getInstance().putStudentMap(name, lineX, lineY);
        LabelRenderer.labels.add(new Label(name,TheClass.getSeatPos(lineX,lineY)[0],TheClass.getSeatPos(lineX,lineY)[1],100,40));
        //ListUtil.decompile(LabelRenderer.labels);

        FramePanel.getInsane().reFreshLabel();
    }
}
