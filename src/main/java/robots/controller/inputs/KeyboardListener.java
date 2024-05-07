package robots.controller.inputs;


import robots.view.scenes.Game;
import robots.view.scenes.GameStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static robots.view.scenes.GameStates.PLAYING;


public class KeyboardListener implements KeyListener {
    private Game game;

    public KeyboardListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (GameStates.gameState == PLAYING)
            game.getPlaying().keyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
