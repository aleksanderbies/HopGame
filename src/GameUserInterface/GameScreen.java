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
    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    public static final float GRAVITY = 0.1f;
    public static final float GROUND = 480;
    private MainHero mainHero;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private ObstaclesManager obstaclesManager;
    private float score = 0.0f;

    private int gameState = GAME_FIRST_STATE;
    public GameScreen(){
        thread = new Thread(this);
        mainHero = new MainHero();
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
        g.setColor(Color.black);
        g.drawLine(0,(int) GROUND, getWidth(),(int) GROUND);
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
        }
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
        switch (e.getKeyCode()){
            case KeyEvent.VK_SPACE:
                if (gameState == GAME_FIRST_STATE){
                    gameState = GAME_PLAY_STATE;
                }
                break;
            case KeyEvent.VK_ENTER:
                if(gameState == GAME_OVER_STATE){
                    score = 0.0f;
                    mainHero.setAlive(true);
                    gameState = GAME_FIRST_STATE;
                }
        }

    }

}
