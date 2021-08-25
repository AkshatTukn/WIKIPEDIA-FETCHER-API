package tech.codingclub;


import javax.swing.*;
import java.awt.*;

public class First
{
First(){

    JFrame f= new JFrame();
    JTextArea area= new JTextArea("welcome to Java Swing Introduction");
    area.setBounds(10,30,200,200);
    f.setName("shreyansh jain");
    area.setCaretColor(Color.blue);
    f.add(area);
    f.setSize(300,300);
    f.setLayout(null);
    f.setVisible(true);
}

    public static void main(String[] args) {
        new First();
    }
}