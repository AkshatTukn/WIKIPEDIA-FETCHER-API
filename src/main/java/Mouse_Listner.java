import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse_Listner extends Frame implements MouseListener {

    Mouse_Listner(){
        addMouseListener(this);
        setSize(100,100);
        setLayout(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        new Mouse_Listner();
    }

    public void mouseClicked(MouseEvent e) {
        Graphics g=getGraphics();
        g.setColor(Color.BLUE);
        g.fillOval(e.getX(),e.getY(),10,10);
    }


    public void mousePressed(MouseEvent e) {
        Graphics g=getGraphics();
        g.setColor(Color.DARK_GRAY);
        g.fillOval(e.getX(),e.getY(),10,10);

    }

    public void mouseReleased(MouseEvent e) {
        Graphics g=getGraphics();
        g.setColor(Color.yellow);
        g.fillOval(e.getX(),e.getY(),10,10);

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
