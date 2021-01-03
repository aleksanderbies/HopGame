package GameUserInterface;

import GameObjects.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    // ********************************
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
    // ************************************

    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    public static final int GAME_MENU_STATE = 3;

    public static final int FOX = 0;
    public static final int MONKEY = 1;
    public static final int HUMAN = 2;
    public static final int SANTA = 3;

    public static int character;

    public static final float GRAVITY = 0.1f;
    public static final float GROUND = 480;
    private MainHero mainHero;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private ObstaclesManager obstaclesManager;
    private float score = 0.0f;

    public static int gameState = GAME_MENU_STATE;
    public GameScreen(){
        thread = new Thread(this);
        mainHero = new MainHero();
        mainHero.setX(50);
        land = new Land(this);
        clouds = new Clouds();
        obstaclesManager = new ObstaclesManager(mainHero);
    }
    public void startGame(){
        thread.start();
    }
    @Override
    public void run(){
        while (true){
                try {
                    if(gameState == GAME_PLAY_STATE) {
                        update();
                        score += 0.1;
                    }
                    repaint();
                    Thread.sleep(20);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

    public void update(){
        mainHero.update();
        land.update();
        clouds.update();
        obstaclesManager.update();
        if (mainHero.getAlive() == false){
            gameState = GAME_OVER_STATE;
        }
    }
    @Override
    public void paint (Graphics g){
        Image background = Toolkit.getDefaultToolkit().getImage("images/BG-1.png");
        g.drawImage(background, 0, 0, this);
        switch (gameState){
            case GAME_FIRST_STATE:
                clouds.draw(g);
                land.draw(g);
                g.setFont(new Font("Helvetica", Font.BOLD,50));
                g.drawString("Press space to start", 380,200);
                mainHero.draw(g);
                break;
            case GAME_PLAY_STATE:
                clouds.draw(g);
                land.draw(g);
                g.setFont(new Font("Helvetica", Font.BOLD,20));
                g.drawString("Score: "+String.valueOf((int) Math.floor(score)), 1100,50);
                mainHero.draw(g);
                obstaclesManager.draw(g);
                break;
            case GAME_OVER_STATE:
                clouds.draw(g);
                land.draw(g);
                g.setFont(new Font("Helvetica", Font.BOLD,20));
                g.drawString("Score: "+String.valueOf((int) Math.floor(score)), 1100,50);
                g.setFont(new Font("Helvetica", Font.BOLD,50));
                g.drawString("Game Over!", 502,200);
                g.setFont(new Font("Helvetica", Font.BOLD,30));
                g.drawString("Press Enter to play again", 460,250);
                mainHero.draw(g);
                obstaclesManager.draw(g);
                break;
            case GAME_MENU_STATE:
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
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
        if(gameState == GAME_PLAY_STATE) {
            mainHero.jump();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if (gameState == GAME_FIRST_STATE){
                    gameState = GAME_PLAY_STATE;
                }
                break;
            case KeyEvent.VK_ENTER:
                if(gameState == GAME_OVER_STATE){
                    score = 0.0f;
                    obstaclesManager.reset();
                    mainHero.setAlive(true);
                    gameState = GAME_PLAY_STATE;
                }
        }
    }
}
