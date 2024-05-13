package robots.view.scenes;

import robots.model.main.Game;
import robots.view.ui.MyButton;
import robots.model.i18n.I18nProvider;

import java.awt.*;
import java.awt.event.KeyEvent;

import static robots.model.main.GameStates.*;

public class Menu extends GameScene implements SceneMethods {

    private MyButton bPlaying, bEdit, bQuit;

    public Menu(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {

        int w = 150;
        int h = w / 3;
        int x = 640 / 2 - w / 2;
        int y = 150;
        int yOffset = 100;

        bPlaying = new MyButton(I18nProvider.getGameMessage("game_menu_play_btn"), x, y, w, h);
        bEdit = new MyButton(I18nProvider.getGameMessage("game_menu_edit_btn"), x, y + yOffset, w, h);
        bQuit = new MyButton(I18nProvider.getGameMessage("game_menu_quit_btn"), x, y + yOffset * 2, w, h);

    }

    @Override
    public void render(Graphics g) {

        drawButtons(g);

    }

    private void drawButtons(Graphics g) {
        bPlaying.setText(I18nProvider.getGameMessage("game_menu_play_btn"));
        bEdit.setText(I18nProvider.getGameMessage("game_menu_edit_btn"));
        bQuit.setText(I18nProvider.getGameMessage("game_menu_quit_btn"));

        bPlaying.draw(g);
        bEdit.draw(g);
        bQuit.draw(g);

    }

    @Override
    public void mouseClicked(int x, int y) {

        if (bPlaying.getBounds().contains(x, y))
            SetGameState(PLAYING);
        else if (bEdit.getBounds().contains(x, y))
            SetGameState(EDIT);
        else if (bQuit.getBounds().contains(x, y))
            System.exit(0);
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(false);
        bEdit.setMouseOver(false);
        bQuit.setMouseOver(false);

        if (bPlaying.getBounds().contains(x, y))
            bPlaying.setMouseOver(true);
        else if (bEdit.getBounds().contains(x, y))
            bEdit.setMouseOver(true);
        else if (bQuit.getBounds().contains(x, y))
            bQuit.setMouseOver(true);

    }

    @Override
    public void mousePressed(int x, int y) {

        if (bPlaying.getBounds().contains(x, y))
            bPlaying.setMousePressed(true);
        else if (bEdit.getBounds().contains(x, y))
            bEdit.setMousePressed(true);
        else if (bQuit.getBounds().contains(x, y))
            bQuit.setMousePressed(true);

    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();
    }

    private void resetButtons() {
        bPlaying.resetBooleans();
        bEdit.resetBooleans();
        bQuit.resetBooleans();

    }

    @Override
    public void mouseDragged(int x, int y) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

}