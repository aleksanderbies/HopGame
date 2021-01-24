package GameObjects;

import util.ChooseCharacter;
import util.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;

import static GameUserInterface.GameScreen.GROUND;

// Bomb obstacle class
public class Bomb {
    private float x = 500;
    private float y = 0;
    private float speedY = 0;
    private Rectangle rect;
    private MainHero mainHero;
    private BufferedImage bomb, exp;

    public Bomb(MainHero mainHero){
        this.mainHero = mainHero;
        rect = new Rectangle((int) x, (int) y,70,70);
        bomb = Resource.getResourceImage(ChooseCharacter.bombPath);
        exp = Resource.getResourceImage(ChooseCharacter.explosionPath);
    }

    // Updates bomb position and check if main hero have collision with that bomb
    public void update(){ 
        if(new Rectangle((int)x,(int) y,70, 70).intersects(mainHero.getBound()) && !Boots.collectedBoots){
            mainHero.setAlive(false);
        }
        else if(y < GROUND - rect.getHeight()){
            y+=5;
        }
        else {
            y = (float) (GROUND - rect.getHeight());
            x-=2;
        }
    }

    // Draw bomb on game screen
    public void draw(Graphics g){
        if(x <= 125) g.drawImage(exp, (int) x, (int) y, null);
        else g.drawImage(bomb, (int) x, (int) y, null);
    }

    // Reset bomb position
    public void reset(){
        x = 500;
        y = 0;
    }
}
