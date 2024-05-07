package robots.view.windows;

import robots.controller.inputs.KeyboardListener;
import robots.controller.inputs.MyMouseListener;
import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;
import robots.view.AbstractWindow;
import robots.view.scenes.Game;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends AbstractWindow {
    private final Game game;
    private MyMouseListener myMouseListener;
    private KeyboardListener keyboardListener;

    public GameWindow() {
        super(I18nProvider.getMessage(I18nBundles.GAME_WINDOW, "game_window_name"), true, true, true, true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        game = new Game();
        game.start();
        initInputs();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(game, BorderLayout.CENTER);
        getContentPane().add(panel);
        pack();

    }

    @Override
    public void onUiChanged() {
        setTitle(I18nProvider.getMessage(I18nBundles.GAME_WINDOW, "game_window_name"));
        revalidate();
        repaint();
    }

    @Override
    protected void closeWindow() {

    }


    public void initInputs() {
        myMouseListener = new MyMouseListener(game);
        keyboardListener = new KeyboardListener(game);

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.getRender().render(g);
    }
}
