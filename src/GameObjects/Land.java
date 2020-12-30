package GameObjects;

import util.Resource;
import static GameUserInterface.GameScreen.GROUND;

import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Land {

    private List <ImageLand> listImage;
    private BufferedImage imageLand1;

    public Land(){
        listImage = new ArrayList<ImageLand>();
        imageLand1= Resource.getResourceImage("images/ground-1.png");
        float Counter = 1280/imageLand1.getWidth();
        System.out.println(Counter);
        for (int i = 0; i<(int) Counter + 1; i++){
            ImageLand land = new ImageLand();
            land.X_pos = (int) (i * imageLand1.getWidth());
            land.image = imageLand1;
            listImage.add(land);
        }
    }
    public void draw(Graphics g){
        for(ImageLand imageLand:listImage) {
            g.drawImage(imageLand.image, imageLand.X_pos, (int) GROUND, null);
        }
    }

    private class ImageLand{
        int X_pos;
        BufferedImage image;
    }
}
