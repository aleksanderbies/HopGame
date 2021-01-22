package GameObjects;

import GameUserInterface.GameScreen;
import util.ChooseCharacter;
import util.Resource;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObstaclesManager {
    private List<Obstacles> obstacles;
    private Random random;

    private BufferedImage cactus1, cactus2;
    private MainHero mainHero;
    private Bomb bomb;
    private BonusCoin coin;
    private Boots boots;

    public ObstaclesManager(MainHero mainHero){
        this.mainHero = mainHero;
        obstacles = new ArrayList<Obstacles>();
        cactus1 = Resource.getResourceImage(ChooseCharacter.obstacle1Path);
        cactus2 = Resource.getResourceImage(ChooseCharacter.obstacle2Path);
        random = new Random();
        obstacles.add(getRandomObstacle());
        random = new Random();
        bomb = GameScreen.bomb;
        coin = GameScreen.coin;
        boots = GameScreen.boots;
    }
    public void update(){
        for (Obstacles o : obstacles){
            o.update();
            if(o.getBound().intersects(mainHero.getBound()) && !Boots.collectedBoots){
                mainHero.setAlive(false);
            }
        }
        Obstacle firstObstacle = (Obstacle) obstacles.get(0);
        if(obstacles.get(0).outOfScreen()){
            obstacles.remove(firstObstacle);
            obstacles.add(getRandomObstacle());
            bomb.reset();
            GameScreen.obstaclesAvoided++;
            BonusCoin.info = false;
            if (GameScreen.obstaclesAvoided == 3) {
                GameScreen.obstaclesAvoided = 0;
                if (Boots.collectedBoots) {
                    GameScreen.SPEED_LEVEL = GameScreen.oldSpeed;
                    Boots.collectedBoots = false;
                }
                if (random.nextInt(10) > 4){
                    coin.reset();
                } else {
                    boots.reset();
                }
            }
        }
    }
    public void draw(Graphics g){
        for (Obstacles o : obstacles){
            o.draw(g);
        }
    }
    public void reset(){
        obstacles.clear();
        obstacles.add(getRandomObstacle());
    }
    public Obstacle getRandomObstacle(){
        Obstacle obstacle;
        obstacle = new Obstacle();
        obstacle.setX(1280);
        if (random.nextBoolean()){
            obstacle.setImage(cactus1);
        }else{
            obstacle.setImage(cactus2);
        }
        return obstacle;
    }
}
