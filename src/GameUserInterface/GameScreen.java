package GameUserInterface;

import GameObjects.*;
import util.ChooseCharacter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GameScreen extends JPanel implements Runnable, KeyListener {

    // ************************************
    // Menu variables
    public static boolean[] checked = {true, false, false, false};

    public static final int FOX = 0;
    public static final int MONKEY = 1;
    public static final int HUMAN = 2;
    public static final int SANTA = 3;
    public static int character = FOX;

    private final Shape foxFrame = new Rectangle2D.Float(100, 325, 120, 120);
    private final Shape monkeyFrame = new Rectangle2D.Float(420, 325, 120, 120);
    private final Shape humanFrame = new Rectangle2D.Float(750, 325, 120, 120);
    private final Shape santaFrame = new Rectangle2D.Float(1050, 325, 120, 120);

    private final Image foxImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_fox.png");
    private final Image monkeyImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_monkey.png");
    private final Image humanImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_human.png");
    private final Image santaImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_santa.png");
    private final Image backgroundImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/menu_background.png");
    private final Image titleImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/title.png");
    private final Image chooseImg = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/choose_text.png");
    private final Image startGameGif = Toolkit.getDefaultToolkit().getImage("images/choose_character_images/start_game.gif");
    private final Image backToMenuImg = Toolkit.getDefaultToolkit().getImage("images/texts/back_to_menu.gif");
    private final Image score100Img = Toolkit.getDefaultToolkit().getImage("images/texts/score100.png");
    private final Image immortalImg = Toolkit.getDefaultToolkit().getImage("images/texts/immortal.png");
    // ************************************
    // Game variables
    public static final int GAME_FIRST_STATE = 0;
    public static final int GAME_PLAY_STATE = 1;
    public static final int GAME_OVER_STATE = 2;
    public static final int GAME_MENU_STATE = 3;

    public static final float GRAVITY = 0.1f;
    public static final float GROUND = 480;

    public static int SPEED_LEVEL = 20;
    private boolean changedSpeed = false;
    private MainHero mainHero;
    private Thread thread;
    private Land land;
    private Clouds clouds;
    private ObstaclesManager obstaclesManager;
    public static Bomb bomb;
    public static BonusCoin coin;
    public static Boots boots;
    public static ChooseCharacter chooseCharacter;
    public static float score = 0.0f;
    public static int obstaclesAvoided = 0;
    public static int oldSpeed;


    public static int gameState = GAME_MENU_STATE;

    private final Image pressSpaceImg = Toolkit.getDefaultToolkit().getImage("images/texts/press_space.png");
    private final Image gameoverImg = Toolkit.getDefaultToolkit().getImage("images/texts/game_over.png");
    private final Image pressEnterImg = Toolkit.getDefaultToolkit().getImage("images/texts/press_enter.png");

    File bg_sound = new File(ChooseCharacter.bgMusic);

    public GameScreen(){
        thread = new Thread(this);
        chooseCharacter = new ChooseCharacter();
    }

    public void startGame(){
        thread.start();
    }

    @Override
    public void run(){
        playMusic();
        while (true){
                try {
                    if(gameState == GAME_PLAY_STATE) {
                        update();
                        score += 0.1;
                    }
                    repaint();
                    Thread.sleep(SPEED_LEVEL);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

    public void update(){
        updateSpeed();
        mainHero.update();
        land.update();
        clouds.update();
        bomb.update();
        coin.update();
        boots.update();
        obstaclesManager.update();
        if (mainHero.getAlive() == false){
            gameState = GAME_OVER_STATE;
        }
    }

    private void updateSpeed() {
        if (SPEED_LEVEL - 3 > 1) {
            if (changedSpeed == false) {
                if (Math.abs((int) score) % 100 == 50) {
                    SPEED_LEVEL -= 3;
                    changedSpeed = true;
                } else if (Boots.collectedBoots) {
                    SPEED_LEVEL = 2;
                    changedSpeed = true;
                }
            } else if (Math.abs((int) score) % 100 != 50) {
                changedSpeed = false;
            }
        }
    }

    @Override
    public void paint (Graphics g){
        Image background = Toolkit.getDefaultToolkit().getImage(ChooseCharacter.backgroundPath);
        g.drawImage(background, 0, 0, this);
        switch (gameState){
            case GAME_FIRST_STATE:
                mainHero = new MainHero();
                mainHero.setX(50);
                bomb = new Bomb(mainHero);
                coin = new BonusCoin(mainHero);
                boots = new Boots(mainHero);
                land = new Land(this);
                clouds = new Clouds();
                obstaclesManager = new ObstaclesManager(mainHero);
                score = 0.0f;
                changedSpeed = false;
                SPEED_LEVEL = 20;
                clouds.draw(g);
                land.draw(g);
                g.drawImage(pressSpaceImg, 380, 200, this);
                g.drawImage(backToMenuImg, 1000, 598, this);
                mainHero.draw(g);
                break;
            case GAME_PLAY_STATE:
                clouds.draw(g);
                land.draw(g);
                g.setFont(new Font("Helvetica", Font.BOLD,20));
                g.drawString("Score: "+String.valueOf((int) Math.floor(score)), 1100,50);
                g.drawImage(backToMenuImg, 1000, 598, this);
                if (Boots.collectedBoots) g.drawImage(immortalImg, 350, 80, this);
                else if (BonusCoin.info) g.drawImage(score100Img, 450, 80, this);
                mainHero.draw(g);
                obstaclesManager.draw(g);
                bomb.draw(g);
                boots.draw(g);
                coin.draw(g);
                break;
            case GAME_OVER_STATE:
                clouds.draw(g);
                land.draw(g);
                g.setFont(new Font("Helvetica", Font.BOLD,20));
                g.drawString("Score: "+String.valueOf((int) Math.floor(score)), 1100,50);
                g.drawImage(gameoverImg,450, 200, this);
                g.drawImage(pressEnterImg, 380, 270, this);
                g.drawImage(backToMenuImg, 1000, 598, this);
                mainHero.draw(g);
                obstaclesManager.draw(g);
                bomb.draw(g);
                coin.draw(g);
                boots.draw(g);
                break;
            case GAME_MENU_STATE:
                Graphics2D g2d = (Graphics2D) g;

                // Background
                g2d.drawImage(backgroundImg, 0 ,0, this);

                // Game title
                g2d.drawImage(titleImg, 450 ,30, this);

                // Buttons
                g2d.drawImage(startGameGif, 470, 500, this);

                // Choose character
                Color checkColor = new Color(38, 38, 38, 144);
                g2d.drawImage(chooseImg, 380, 250, this);

                g2d.setColor(Color.BLACK);
                g2d.draw(foxFrame);
                if (checked[0]) {
                    g2d.setColor(checkColor);
                    g2d.fill(foxFrame);
                    g2d.setColor(Color.BLACK);
                }
                g2d.drawImage(foxImg, foxFrame.getBounds().x, foxFrame.getBounds().y + 10, this);

                g2d.draw(monkeyFrame);
                if (checked[1]) {
                    g2d.setColor(checkColor);
                    g2d.fill(monkeyFrame);
                    g2d.setColor(Color.BLACK);
                }
                g2d.drawImage(monkeyImg, monkeyFrame.getBounds().x + 12, monkeyFrame.getBounds().y, this);

                g2d.draw(humanFrame);
                if (checked[2]) {
                    g2d.setColor(checkColor);
                    g2d.fill(humanFrame);
                    g2d.setColor(Color.BLACK);
                }
                g2d.drawImage(humanImg, humanFrame.getBounds().x + 20, humanFrame.getBounds().y, this);

                g2d.draw(santaFrame);
                if (checked[3]) {
                    g2d.setColor(checkColor);
                    g2d.fill(santaFrame);
                    g2d.setColor(Color.BLACK);
                }
                g2d.drawImage(santaImg, santaFrame.getBounds().x + 20, santaFrame.getBounds().y, this);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
        if(gameState == GAME_PLAY_STATE && mainHero.getY() == GROUND - MainHero.heroRun.getFrame().getHeight()) {
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
                    bomb.reset();
                    coin.reset();
                    boots.hardReset();
                    gameState = GAME_PLAY_STATE;
                    changedSpeed = false;
                    SPEED_LEVEL = 20;
                }
        }
    }
    private void playMusic(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bg_sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-20f);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
     