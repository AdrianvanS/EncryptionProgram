package com.avsk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash2 extends JPanel implements ActionListener {

    JFrame frame;
    Timer timer;
    Startup start;

    Splash2(){

        frame = new JFrame();
        frame.setUndecorated(true);
        JPanel panel = new JPanel();
        frame.setBackground(new Color(0,0,0, 0));
        panel.setBackground(new Color(0,0,0,0));

        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("avs_braces.png").getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH));
        label.setIcon(imageIcon);
        label.setBackground(new Color(0,0,0,0));


        panel.add(label);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        timer = new Timer(1000, this);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        start.discardFrame(this.frame);
    }

    public void setStart(Startup start){
        this.start = start;
    }
}
