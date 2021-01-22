package GameObjects;

import GameUserInterface.GameScreen;
import util.ChooseCharacter;
import util.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;
import static GameUserInterface.GameScreen.GROUND;
import static GameUserInterface.GameScreen.oldSpeed;


public class Boots {
    private float x = -200;
    private float y = 0;
    private Rectangle rect;
    private MainHero mainHero;
    private BufferedImage boots;
    public static boolean collectedBoots = false;

    public Boots(MainHero mainHero) {
        this.mainHero = mainHero;
        rect = new Rectangle((int) x, (int) y,70,70);
        boots = Resource.getResourceImage(ChooseCharacter.bootPath);
    }

    public void update() {
        if (new Rectangle((int)x,(int) y,70, 70).intersects(mainHero.getBound()) && !collectedBoots) {
            oldSpeed = GameScreen.SPEED_LEVEL;
            collectedBoots = true;
        }
        else if (y < GROUND - rect.getHeight()) y += 5;
        else {
            y = (float) (GROUND - rect.getHeight());
            x -= 2;
        }
    }

    public void draw(Graphics g) {
        if (x >= 125) g.drawImage(boots, (int) x, (int) y, null);
        else if (x <= 125 && !collectedBoots) g.drawImage(boots, (int) x, (int) y, null);
    }

    public void reset() {
        x = 800;
        y = 0;
        collectedBoots = false;
    }

    public void hardReset() {
        x = -200;
        y = 0;
        collectedBoots = false;
    }
}
