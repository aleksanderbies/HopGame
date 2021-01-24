package util;

import GameUserInterface.GameScreen;

// Class switching paths to images after choosing character
public class ChooseCharacter {

    // All paths with default values
    public static String backgroundPath = "images/backgrounds/BG-1.png";
    public static String groundPath = "images/grounds/ground-1.png";
    public static String hero1Path = "images/heroes/fox-hero-1.png";
    public static String hero2Path = "images/heroes/fox-hero-2.png";
    public static String heroJumpPath = "images/heroes/fox-hero-jmp.png";
    public static String heroDeadPath = "images/heroes/fox-hero-dead.png";
    public static String obstacle1Path = "images/obstacles/Cactus (1).png";
    public static String obstacle2Path = "images/obstacles/Cactus (2).png";
    public static String skyPath = "images/sky/cloud1.png";
    public static String bgMusic = "sounds/rest_bgmusic.wav";
    public static String bombPath = "images/obstacles/bomb.png";
    public static String explosionPath = "images/obstacles/explosion.png";
    public static String coinPath = "images/obstacles/coin.png";
    public static String bootPath = "images/obstacles/boot.png";



    public void changeCharacter() {

        // Switching paths
        switch (GameScreen.character) {
            case GameScreen.FOX:
                backgroundPath = "images/backgrounds/BG-1.png";
                groundPath = "images/grounds/ground-1.png";
                hero1Path = "images/heroes/fox-hero-1.png";
                hero2Path = "images/heroes/fox-hero-2.png";
                heroJumpPath = "images/heroes/fox-hero-jmp.png";
                heroDeadPath = "images/heroes/fox-hero-dead.png";
                obstacle1Path = "images/obstacles/Cactus (1).png";
                obstacle2Path = "images/obstacles/Cactus (2).png";
                skyPath = "images/sky/cloud1.png";
                break;
            case GameScreen.MONKEY:
                backgroundPath = "images/backgrounds/BG-2.png";
                groundPath = "images/grounds/ground-2.png";
                hero1Path = "images/heroes/monkey-hero-1.png";
                hero2Path = "images/heroes/monkey-hero-2.png";
                heroJumpPath = "images/heroes/monkey-hero-jmp.png";
                heroDeadPath = "images/heroes/monkey-hero-dead.png";
                obstacle1Path = "images/obstacles/jungle-tree-1.png";
                obstacle2Path = "images/obstacles/jungle-tree-2.png";
                skyPath = "images/sky/cloud1.png";
                break;
            case GameScreen.HUMAN:
                backgroundPath = "images/backgrounds/BG-3.png";
                groundPath = "images/grounds/ground-3.png";
                hero1Path = "images/heroes/human-hero-1.png";
                hero2Path = "images/heroes/human-hero-2.png";
                heroJumpPath = "images/heroes/human-hero-jmp.png";
                heroDeadPath = "images/heroes/human-hero-dead.png";
                obstacle1Path = "images/obstacles/forest-tree.png";
                obstacle2Path = "images/obstacles/forest-obstacle.png";
                skyPath = "images/sky/cloud1.png";
                break;
            case GameScreen.SANTA:
                backgroundPath = "images/backgrounds/BG-4.png";
                groundPath = "images/grounds/ground-4.png";
                hero1Path = "images/heroes/santa-hero-1.png";
                hero2Path = "images/heroes/santa-hero-2.png";
                heroDeadPath = "images/heroes/santa-hero-dead.png";
                heroJumpPath = "images/heroes/santa-hero-jmp.png";
                obstacle1Path = "images/obstacles/christmas-tree.png";
                obstacle2Path = "images/obstacles/snowman-winter.png";
                skyPath = "images/sky/xmas-star.png";
                break;
        }
    }
}
