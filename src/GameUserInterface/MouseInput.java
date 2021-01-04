package GameUserInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= 580 && mouseX <= 780 && mouseY >= 200 && mouseY <= 250) {
            GameScreen.gameState = GameScreen.GAME_FIRST_STATE;
            System.out.println("New game clicked");
        } else if (mouseX >= 580 && mouseX <= 780 && mouseY >= 470 && mouseY <= 520) {
            System.exit(1);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseY >= 375 && mouseY <= 495) {
            if (mouseX >= 400 && mouseX <= 520) {
                GameScreen.character = GameScreen.FOX;
                GameScreen.checked[0] = !GameScreen.checked[0];
                System.out.println("Fox");
            } else if (mouseX >= 550 && mouseX <= 670) {
                GameScreen.character = GameScreen.MONKEY;
                GameScreen.checked[1] = !GameScreen.checked[1];
                System.out.println("Monkey");
            } else if (mouseX >= 700 && mouseX <= 820) {
                GameScreen.character = GameScreen.HUMAN;
                GameScreen.checked[2] = !GameScreen.checked[2];
                System.out.println("Human");
            } else if (mouseX >= 850 && mouseX <= 970) {
                GameScreen.character = GameScreen.SANTA;
                GameScreen.checked[3] = !GameScreen.checked[3];
                System.out.println("Santa");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= 580 && mouseX <= 780 && mouseY >= 200 && mouseY <= 250) {
            GameScreen.hoverNewGame = true;
        } else if (mouseX >= 580 && mouseX <= 780 && mouseY >= 470 && mouseY <= 520) {
            //GameScreen.hover = true;
        } else if (mouseY >= 325 && mouseY <= 445) {
            if (mouseX >= 400 && mouseX <= 520) {
                //GameScreen.hover = true;
            } else if (mouseX >= 550 && mouseX <= 670) {
                //GameScreen.hover = true;
            } else if (mouseX >= 700 && mouseX <= 820) {
                //GameScreen.hover = true;
            } else if (mouseX >= 850 && mouseX <= 970) {
                //GameScreen.hover = true;
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= 580 && mouseX <= 780 && mouseY >= 200 && mouseY <= 250) {
            GameScreen.hoverNewGame = false;
        } else if (mouseX >= 580 && mouseX <= 780 && mouseY >= 470 && mouseY <= 520) {
            //GameScreen.hover = false;
        } else if (mouseY >= 325 && mouseY <= 445) {
            if (mouseX >= 400 && mouseX <= 520) {
               // GameScreen.hover = false;
            } else if (mouseX >= 550 && mouseX <= 670) {
                //GameScreen.hover = false;
            } else if (mouseX >= 700 && mouseX <= 820) {
                //GameScreen.hover = false;
            } else if (mouseX >= 850 && mouseX <= 970) {
                //GameScreen.hover = false;
            }
        }
    }
}
