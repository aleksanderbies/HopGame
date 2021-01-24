package GameObjects;

import util.ChooseCharacter;
import util.Resource;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

public class Clouds {
    private BufferedImage cloudImage;
    private List <Cloud> clouds;

    public  Clouds(){
        cloudImage = Resource.getResourceImage(ChooseCharacter.skyPath);
        clouds = new ArrayList<Cloud>();

        Cloud cloud1 = new Cloud();
        cloud1.X_pos = 100;
        cloud1.Y_pos = 50;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.X_pos = 300;
        cloud1.Y_pos = 100;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.X_pos = 600;
        cloud1.Y_pos = 70;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.X_pos = 800;
        cloud1.Y_pos = 60;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.X_pos = 1100;
        cloud1.Y_pos = 90;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.X_pos = 1200;
        cloud1.Y_pos = 40;
        clouds.add(cloud1);
    }
    //update of clouds X coordinate, makes that clouds moving
    public void update(){
        for (Cloud cloud : clouds){
            cloud.X_pos --;
        }
        Cloud firstCloud = clouds.get(0);
        if (firstCloud.X_pos + cloudImage.getWidth() < 0){
            firstCloud.X_pos = 1280;
            clouds.remove(firstCloud);
            clouds.add(firstCloud);
        }

    }
    //drawing the clouds
    public void draw(Graphics g){
        for(Cloud cloud : clouds) {
            g.drawImage(cloudImage, (int) cloud.X_pos, (int) cloud.Y_pos, null);
        }
    }
    //class to make a list of clouds
    private class Cloud{
        float X_pos;
        float Y_pos;
    }
}
