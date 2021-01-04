package GameObjects;

import util.ChooseCharacter;
import util.Resource;
import static GameUserInterface.GameScreen.GROUND;

import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import GameUserInterface.GameScreen;
public class Land {

    private List <ImageLand> listImage;
    private BufferedImage imageLand1;

    public Land(GameScreen game){
        listImage = new ArrayList<ImageLand>();
        imageLand1= Resource.getResourceImage(ChooseCharacter.groundPath);
        float Counter = 1280/imageLand1.getWidth();
        System.out.println(Counter);
        for (int i = 0; i<(int) Counter + 1; i++){
            ImageLand land = new ImageLand();
            land.X_pos = (int) (i * imageLand1.getWidth());
            land.image = imageLand1;
            listImage.add(land);
        }
    }
    public void update(){
        for (ImageLand imageLand : listImage){
            imageLand.X_pos --;
        }
        ImageLand firstEl = listImage.get(0);
        if(firstEl.X_pos + imageLand1.getWidth() < 0){
            firstEl.X_pos = listImage.get(listImage.size() - 1).X_pos + imageLand1.getWidth();
            listImage.add(firstEl);
            listImage.remove(0);
        }
    }
    public void draw(Graphics g){
        for(ImageLand imageLand:listImage) {
            g.drawImage(imageLand.image, imageLand.X_pos, (int) GROUND-5, null);
        }
    }

    private class ImageLand{
        int X_pos;
        BufferedImage image;
    }
}
