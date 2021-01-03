package GameUserInterface;

import javafx.scene.layout.BackgroundImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

public class WindowGame extends JFrame{

    private GameScreen gameScreen;
    private StartMenu startMenu;
    Container contentPane;

    public WindowGame(){

        super ("HopGame in Java by Aleksander Bies & Adam Chylaszek");
        setSize(1280, 680);
        setMaximumSize(new Dimension(1280,680));
        setMinimumSize(new Dimension(1280,680));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen = new GameScreen();
        startMenu = new StartMenu();
        contentPane = getContentPane();

    }
    public void startGame(){
        add(gameScreen);
        addKeyListener(gameScreen);
        gameScreen.startGame();
    }

    public void createMenu() {
        add(startMenu);
        startMenu.addMouseListener(new MouseInput());
        startMenu.createMenu();
    }

    public static void main (String args[]){
        WindowGame gw = new WindowGame();

        gw.setVisible(true);
        //gw.startGame();
        gw.createMenu();
    }
}
