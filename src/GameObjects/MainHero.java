package GameObjects;

import util.Resource;
import util.Animation;

import java.awt.*;
import java.awt.image.BufferedImage;

import static GameUserInterface.GameScreen.GRAVITY;
import static GameUserInterface.GameScreen.GROUND;

public class MainHero {
    private float x = 0;
    private float y = 380;
    private float speedY = 0;
    public static Animation heroRun;
    private Rectangle rect;
    private boolean alive = true;


    public MainHero(){
        heroRun =  new Animation(200);
        heroRun.addFrame(Resource.getResourceImage("images/fox-hero-1.png"));
        heroRun.addFrame(Resource.getResourceImage("images/fox-hero-2.png"));
        rect = new Rectangle();
    }

    public void update(){
        heroRun.update();
        if(y >= GROUND - heroRun.getFrame().getHeight()){
            speedY = 0;
            y = GROUND - heroRun.getFrame().getHeight();
        }else {
            speedY += GRAVITY;
            y += speedY;
        }
        rect.x = (int) x;
        rect.y = (int) y;
        rect.width = heroRun.getFrame().getWidth();
        rect.height = heroRun.getFrame().getHeight();
    }
    public Rectangle getBound(){
        return rect;
    }
    public void draw(Graphics g){
        //g.drawRect((int) x,(int) y, heroRun.getFrame().getWidth(), heroRun.getFrame().getHeight());
        if(!getAlive()){
            g.drawImage(Resource.getResourceImage("images/fox-hero-dead.png"), (int) x, (int) y, null);
        }
        else g.drawImage(heroRun.getFrame(), (int) x, (int)y , null );
    }

    public void jump(){
        speedY = -7;
        y += speedY;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setAlive(boolean alive) {this.alive = alive;}

    public boolean getAlive(){
        return this.alive;
    }

}
