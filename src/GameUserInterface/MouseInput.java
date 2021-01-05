package GameUserInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseX >= 470 && mouseX <= 891 && mouseY >= 500 && mouseY <= 590 && GameScreen.gameState == GameScreen.GAME_MENU_STATE) {
            GameScreen.chooseCharacter.changeCharacter();
            GameScreen.gameState = GameScreen.GAME_FIRST_STATE;
            System.out.println("New game clicked");
        } else if (mouseX >= 1000 && mouseX <= 1258 && mouseY >= 598 && mouseY <= 648 && GameScreen.gameState != GameScreen.GAME_MENU_STATE) {
            GameScreen.gameState = GameScreen.GAME_MENU_STATE;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseY >= 325 && mouseY <= 445 && GameScreen.gameState == GameScreen.GAME_MENU_STATE) {
            if (mouseX >= 100 && mouseX <= 220 && !GameScreen.checked[0]) {
                GameScreen.character = GameScreen.FOX;
                GameScreen.checked[0] = true;
                GameScreen.checked[1] = false;
                GameScreen.checked[2] = false;
                GameScreen.checked[3] = false;
                System.out.println("Fox");
            } else if (mouseX >= 420 && mouseX <= 540 && !GameScreen.checked[1]) {
                GameScreen.character = GameScreen.MONKEY;
                GameScreen.checked[1] = true;
                GameScreen.checked[0] = false;
                GameScreen.checked[2] = false;
                GameScreen.checked[3] = false;
                System.out.println("Monkey");
            } else if (mouseX >= 750 && mouseX <= 870 && !GameScreen.checked[2]) {
                GameScreen.character = GameScreen.HUMAN;
                GameScreen.checked[2] = true;
                GameScreen.checked[1] = false;
                GameScreen.checked[0] = false;
                GameScreen.checked[3] = false;
                System.out.println("Human");
            } else if (mouseX >= 1050 && mouseX <= 1170 && !GameScreen.checked[3]) {
                GameScreen.character = GameScreen.SANTA;
                GameScreen.checked[3] = true;
                GameScreen.checked[1] = false;
                GameScreen.checked[2] = false;
                GameScreen.checked[0] = false;
                System.out.println("Santa");
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
