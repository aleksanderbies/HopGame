package GameUserInterface;

import GameObjects.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel implements Runnable, KeyListener {
    public static final float GRAVITY = 0.1f;
    public static final float GROUND = 480;
    private MainHero mainHero;
    private Thread thread;
    private Land land;
    public GameScreen(){
        thread = new Thread(this);
        mainHero = new MainHero();
        land = new Land(this);
    }
    public void startGame(){
        thread.start();
    }
    @Override
    public void run(){
        while (true){
            try {
                mainHero.update();
                land.update();
                super.repaint();
                Thread.sleep(20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint (Graphics g){
        g.setColor(Color.black);
        g.drawLine(0,(int) GROUND, getWidth(),(int) GROUND);
        land.draw(g);
        mainHero.draw(g);
    }
    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
        mainHero.jump();

    }
    @Override
    public void keyReleased(KeyEvent e){
        System.out.println("Key released");

    }

}
