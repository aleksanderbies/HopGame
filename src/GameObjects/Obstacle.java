package GameObjects;

import util.ChooseCharacter;
import util.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;
import static GameUserInterface.GameScreen.GROUND;

public class Obstacle extends Obstacles{
    private BufferedImage image;
    private int X_pos;
    private int Y_pos;
    private Rectangle rect;

    public Obstacle(){
        image = Resource.getResourceImage(ChooseCharacter.obstacle1Path);
        X_pos = 1280;
        Y_pos = (int) GROUND - image.getHeight();
        rect = new Rectangle();

    }

    @Override
    //update obstacle coordinates
    public void update() {
        X_pos -= 2;
        rect.x = X_pos+5;
        rect.y = Y_pos;
        rect.width = image.getWidth()-25;
        rect.height = image.getHeight()-25;
    }
    @Override
    //drawing the obstacles on the screen
    public void draw(Graphics g) {
        g.drawImage(image, X_pos, Y_pos, null );
    }

    @Override
    //rectangle to check that main hero intersects the obstacle
    public Rectangle getBound() {
        return rect;
    }

    @Override
    //check that obstacle is out of screen
    public boolean outOfScreen() {
        if (X_pos + image.getWidth() < 0){
            return true;
        }else return false;
    }

    //method to set the X coordinate
    public void setX(int x){
        X_pos = x;
    }

    //method to set the Y coordinate
    public void setY(int y){
        X_pos = y;
    }

    //method to set the image
    public void setImage(BufferedImage image){
        this.image = image;
    }
}
