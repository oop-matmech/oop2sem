package robots.view;

import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends AbstractWindow {
    private final GameVisualizer m_visualizer;

    public GameWindow() {
        super(I18nProvider.getMessage(I18nBundles.GAME_WINDOW, "game_window_name"), true, true, true, true);
        m_visualizer = new GameVisualizer();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(m_visualizer, BorderLayout.CENTER);
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

    public GameVisualizer get_visualizer() {
        return m_visualizer;
    }
}
