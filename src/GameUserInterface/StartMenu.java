package GameUserInterface;

import GameObjects.*;
import com.sun.javafx.geom.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartMenu extends JPanel implements Runnable, KeyListener {

    private Thread thread;
    public Shape newGameButton = new Rectangle2D.Float(580, 200, 200, 50);
    public Shape exitGameButton = new Rectangle2D.Float(580, 550, 200, 50);

    public Shape foxFrame = new Rectangle2D.Float(400, 375, 120, 120);
    public Shape monkeyFrame = new Rectangle2D.Float(550, 375, 120, 120);
    public Shape humanFrame = new Rectangle2D.Float(700, 375, 120, 120);
    public Shape santaFrame = new Rectangle2D.Float(850, 375, 120, 120);


    public StartMenu(){
        thread = new Thread(this);
    }
    public void createMenu(){
        thread.start();
    }

    @Override
    public void run(){
        while (true){
            try {
                super.repaint();
                Thread.sleep(20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        // Background
        g.setColor(new Color(20, 89,35));
        g.fillRect(0, 0, 1280, 680);

        // Game title
        Font fnt = new Font("courier", Font.ITALIC, 36);
        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("HOP GAME", 580, 100);

        // Buttons
        Font fntButtons = new Font("courier", Font.ITALIC, 25);
        g.setFont(fntButtons);
        int ngbX = newGameButton.getBounds().x;
        int ngbY = newGameButton.getBounds().y;
        g.drawString("NEW GAME", ngbX + 27, ngbY + 35);
        g2d.draw(newGameButton);
        int egbX = exitGameButton.getBounds().x;
        int egbY = exitGameButton.getBounds().y;
        g.drawString("EXIT GAME", egbX + 27, egbY + 35);
        g2d.draw(exitGameButton);

        // Choose character
        g.drawString("CHOOSE YOUR CHARACTER:", 500, 300);
        g2d.draw(foxFrame);
        g2d.draw(monkeyFrame);
        g2d.draw(humanFrame);
        g2d.draw(santaFrame);

    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}

}
