package robots.view;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractWindow extends JFrame implements UiListener {

    public AbstractWindow(){

    }

    @Override
    public void onUiChanged() {
        revalidate();
        repaint();
    }

    @Override
    public void dispose() {
        closeWindow();
        super.dispose();
    }

    private void closeWindow() {
    }
}
