package GameUserInterface;

import javax.swing.*;
import java.awt.*;

//main class of the game
public class WindowGame extends JFrame{

    private GameScreen gameScreen;

    public WindowGame(){

        super ("HopGame in Java by Aleksander Bies & Adam Chylaszek");
        setSize(1280, 680);
        setMaximumSize(new Dimension(1280,680));
        setMinimumSize(new Dimension(1280,680));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        gameScreen = new GameScreen();
        add(gameScreen);
        addKeyListener(gameScreen);
        gameScreen.addMouseListener(new MouseInput());
    }
    //method starts the game
    public void startGame(){
        gameScreen.startGame();
    }

    public static void main (String args[]) {
        WindowGame gw = new WindowGame();
        gw.setVisible(true);
        gw.startGame();
    }
}
