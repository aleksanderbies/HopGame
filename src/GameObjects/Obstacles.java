package GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;

//abstract class for obstacles
public abstract class Obstacles {
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract Rectangle getBound();
    public abstract boolean outOfScreen();
}
