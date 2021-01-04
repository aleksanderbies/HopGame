package util;

import GameUserInterface.GameScreen;

public class ChooseCharacter {
    private void changeCharacter() {
        switch (GameScreen.character) {
            case GameScreen.FOX:
                System.out.println("Fox cc");
                break;
            case GameScreen.MONKEY:
                System.out.println("monkey cc");
                break;
            case GameScreen.HUMAN:
                System.out.println("human cc");
                break;
            case GameScreen.SANTA:
                System.out.println("santa cc");
                break;
        }
    }
}
