package GameUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;


public class StartMenu extends JPanel implements Runnable, KeyListener {

    private Thread thread;
    public static boolean running = true;
    public static boolean hover = false;
    public static boolean checked = false;

    private final Shape newGameButton = new Rectangle2D.Float(580, 200, 200, 50);
    private final Shape exitGameButton = new Rectangle2D.Float(580, 470, 200, 50);

    private final Shape foxFrame = new Rectangle2D.Float(400, 325, 120, 120);
    private final Shape monkeyFrame = new Rectangle2D.Float(550, 325, 120, 120);
    private final Shape humanFrame = new Rectangle2D.Float(700, 325, 120, 120);
    private final Shape santaFrame = new Rectangle2D.Float(850, 325, 120, 120);

    private final Image foxImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_fox.png");
    private final Image monkeyImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_monkey.png");
    private final Image humanImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_human.png");
    private final Image santaImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_santa.png");

    public StartMenu(){
        thread = new Thread(this);
    }

    public void createMenu(){
        thread.start();
    }

    @Override
    public void run(){
        while (running){
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
        Font fnt = new Font("Helvetica", Font.ITALIC, 36);
        g.setFont(fnt);
        g.setColor(Color.WHITE);
        g.drawString("HOP GAME", 580, 100);

        // Buttons
        Font fntButtons = new Font("Helvetica", Font.ITALIC, 25);
        g.setFont(fntButtons);
        g.drawString("NEW GAME", newGameButton.getBounds().x + 27, newGameButton.getBounds().y + 35);
        g2d.draw(newGameButton);
        g.drawString("EXIT GAME", exitGameButton.getBounds().x + 27, exitGameButton.getBounds().y + 35);
        g2d.draw(exitGameButton);

        // Choose character
        g.drawString("CHOOSE YOUR CHARACTER:", 500, 300);
        g2d.draw(foxFrame);
        g2d.drawImage(foxImg, foxFrame.getBounds().x, foxFrame.getBounds().y + 10, this);
        g2d.draw(monkeyFrame);
        g2d.drawImage(monkeyImg, monkeyFrame.getBounds().x + 12, monkeyFrame.getBounds().y, this);
        g2d.draw(humanFrame);
        g2d.drawImage(humanImg, humanFrame.getBounds().x + 20, humanFrame.getBounds().y, this);
        g2d.draw(santaFrame);
        g2d.drawImage(santaImg, santaFrame.getBounds().x + 20, santaFrame.getBounds().y, this);
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){}

    @Override
    public void keyReleased(KeyEvent e){}

}
