package robots.view;

import robots.view.scenes.Game;
import robots.view.scenes.GameStates;

import java.awt.*;

public class Render {

    private Game game;

    public Render(Game game) {
        this.game = game;
    }

    public void render(Graphics g) {
        switch (GameStates.gameState) {
            case PLAYING:
                game.getPlaying().render(g);
                break;
            case GAME_OVER:
                game.getGameOver().render(g);
                break;
            default:
                break;
        }
    }
}