package GameObjects;

import util.ChooseCharacter;
import util.Resource;
import util.Animation;

import java.awt.*;

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
        heroRun.addFrame(Resource.getResourceImage(ChooseCharacter.hero1Path));
        heroRun.addFrame(Resource.getResourceImage(ChooseCharacter.hero2Path));
        rect = new Rectangle();
    }

    //update the Y coordinates of main Hero
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
    //create rectangle to check that main hero have collision with obstacle
    public Rectangle getBound(){
        return rect;
    }

    //draws the main hero, according of game state
    public void draw(Graphics g){
        if(!getAlive()){
            g.drawImage(Resource.getResourceImage(ChooseCharacter.heroDeadPath), (int) x, (int) y, null);
        }
        else if(this.getY()!= GROUND - heroRun.getFrame().getHeight() && getAlive()){
            g.drawImage(Resource.getResourceImage(ChooseCharacter.heroJumpPath), (int) x, (int) y, null);
        }
        else g.drawImage(heroRun.getFrame(), (int) x, (int)y , null );
    }

    //makes that main hero jump
    public void jump(){
        speedY = -7;
        y += speedY;
    }

    //gets X coordinates
    public float getX() {
        return x;
    }

    //sets X coordinates
    public void setX(float x) {
        this.x = x;
    }

    //gets Y coordinates
    public float getY() {
        return y;
    }

    //sets X coordinates
    public void setY(float y) {
        this.y = y;
    }

    //gets speedY value
    public float getSpeedY() {
        return speedY;
    }

    //sets speedY value
    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    //sets alive value
    public void setAlive(boolean alive) {this.alive = alive;}

    //gets alive value
    public boolean getAlive(){
        return this.alive;
    }

}
