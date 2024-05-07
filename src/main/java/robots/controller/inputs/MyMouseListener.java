package robots.controller.inputs;


import robots.view.scenes.Game;
import robots.view.scenes.GameStates;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    private Game game;

    public MyMouseListener(Game game) {
        this.game = game;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (GameStates.gameState) {
            case PLAYING:
                game.getPlaying().mouseDragged(e.getX(), e.getY());
                break;
            default:
                break;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameStates.gameState) {
            case PLAYING:
                game.getPlaying().mouseMoved(e.getX(), e.getY());
                break;
            case GAME_OVER:
                game.getGameOver().mouseMoved(e.getX(), e.getY());
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            switch (GameStates.gameState) {

                case PLAYING:
                    game.getPlaying().mouseClicked(e.getX(), e.getY());
                    break;
                case GAME_OVER:
                    game.getGameOver().mouseClicked(e.getX(), e.getY());
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameStates.gameState) {

            case PLAYING:
                game.getPlaying().mousePressed(e.getX(), e.getY());
                break;
            case GAME_OVER:
                game.getGameOver().mousePressed(e.getX(), e.getY());
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameStates.gameState) {

            case PLAYING:
                game.getPlaying().mouseReleased(e.getX(), e.getY());
                break;
            case GAME_OVER:
                game.getGameOver().mouseReleased(e.getX(), e.getY());
                break;

            default:
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // We wont use this

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // We wont use this
    }

}
