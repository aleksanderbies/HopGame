package util;

import java.util.*;
import java.awt.image.BufferedImage;

public class Animation {
    private List<BufferedImage> frames;
    private int CurrentFrame = 0;
    private int deltaTime;
    private long prevTime;

    public Animation(int deltaTime){
        this.deltaTime = deltaTime;

        frames = new ArrayList<BufferedImage>();
    }
    public void update(){
        if (System.currentTimeMillis() - prevTime > deltaTime) {
            CurrentFrame++;
            if (CurrentFrame >= frames.size()) {
                CurrentFrame = 0;
            }
            prevTime = System.currentTimeMillis();
        }
    }
    public void addFrame(BufferedImage frame){
        frames.add(frame);
    }

    public BufferedImage getFrame(){
        if(frames.size() >0){
            return  frames.get(CurrentFrame);
        }
        else return null;
    }
}
