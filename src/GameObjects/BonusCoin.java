package GameObjects;

import GameUserInterface.GameScreen;
import util.ChooseCharacter;
import util.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;

import static GameUserInterface.GameScreen.GROUND;

// Bonus coin class
public class BonusCoin {
    private float x = 800;
    private float y = 0;
    private Rectangle rect;
    private MainHero mainHero;
    private BufferedImage coin;
    private boolean collectedCoin = false;
    public static boolean info = false;

    public BonusCoin(MainHero mainHero) {
        this.mainHero = mainHero;
        rect = new Rectangle((int) x, (int) y,50,50);
        coin = Resource.getResourceImage(ChooseCharacter.coinPath);
    }

    // Updates bonus coin position and check if main hero collected coin
    public void update() {
        if (new Rectangle((int)x,(int) y,50, 50).intersects(mainHero.getBound()) && !collectedCoin) {
            GameScreen.score += 100;
            collectedCoin = true;
            info = true;
        }
        else if (y < GROUND - rect.getHeight()) y += 5;
        else {
            y = (float) (GROUND - rect.getHeight());
            x -= 2;
        }
    }

    // Draw coin on game screen
    public void draw(Graphics g) {
        if (x >= 125) g.drawImage(coin, (int) x, (int) y, null);
        else if (x <= 125 && !collectedCoin) g.drawImage(coin, (int) x, (int) y, null);
    }

    // Reset coin position
    public void reset() {
        x = 800;
        y = 0;
        collectedCoin = false;
    }
}
