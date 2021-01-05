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
    public void update() {
        X_pos -= 2;
        rect.x = X_pos+5;
        rect.y = Y_pos;
        rect.width = image.getWidth()-25;
        rect.height = image.getHeight()-25;
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, X_pos, Y_pos, null );
    }

    @Override
    public Rectangle getBound() {
        return rect;
    }

    @Override
    public boolean outOfScreen() {
        if (X_pos + image.getWidth() < 0){
            return true;
        }else return false;
    }

    public void setX(int x){
        X_pos = x;
    }

    public void setY(int y){
        X_pos = y;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }
}
