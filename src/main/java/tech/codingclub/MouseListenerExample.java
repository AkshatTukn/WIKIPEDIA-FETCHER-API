package tech.codingclub;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerExample extends Frame implements MouseListener{
    Label l;
    MouseListenerExample(){
        addMouseListener(this);

        l=new Label();
        l.setBounds(20,50,100,20);
        add(l);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }
    public void mouseClicked(MouseEvent e) {
        l.setBackground(Color.blue);
    }
    public void mouseEntered(MouseEvent e) {
        l.setText("Mouse Entered");
        l.setBackground(Color.MAGENTA);
    }
    public void mouseExited(MouseEvent e) {
        l.setText("Mouse Exited");
        l.setBackground(Color.RED);
    }
    public void mousePressed(MouseEvent e) {
        l.setText("Mouse Pressed");
        l.setBackground(Color.yellow);
    }
    public void mouseReleased(MouseEvent e) {
        l.setText("Mouse Released");
        l.setBackground(Color.black);
    }
    public static void main(String[] args) {
        new MouseListenerExample();
    }
}