package GameUserInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= 580 && mouseX <= 780 && mouseY >= 200 && mouseY <= 250) {
            // TODO
        } else if (mouseX >= 580 && mouseX <= 780 && mouseY >= 550 && mouseY <= 600) {
            System.exit(1);
        }
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
}
