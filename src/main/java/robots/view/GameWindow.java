package robots.view;

import robots.model.helpz.profileManager;
import robots.model.main.Game;
import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;

public class GameWindow extends AbstractWindow {

    public GameWindow() {
        super(I18nProvider.getGameMessage("game_window_name"), true, true, true, true);
        Game game = new Game();
        game.gameScreen.initInputs();
        game.start();
        //  setResizable(false);
        getContentPane().add(game.gameScreen);
        pack();
    }

    @Override
    public void onUiChanged() {
        setTitle(I18nProvider.getGameMessage("game_window_name"));
        revalidate();
        repaint();
    }

    @Override
    protected void closeWindow() {
        profileManager.setGameWindowIsClosed(true);
    }
}
