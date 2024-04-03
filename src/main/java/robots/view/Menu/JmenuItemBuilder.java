package robots.view.Menu;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JmenuItemBuilder {
    public JMenuItem jMenuItem;

    public static class Builder {
        public JMenuItem jMenuItem = new JMenuItem();

        public Builder setText(String text) {
            jMenuItem.setText(text);
            return this;
        }

        public Builder setMnemonic(int keyevent) {
            jMenuItem.setMnemonic(keyevent);
            return this;
        }

        public Builder addActionListener(ActionListener actionListener) {
            jMenuItem.addActionListener(actionListener);
            return this;
        }

        public Builder jMenuItem(JMenuItem jMenuItem_) {
            jMenuItem = jMenuItem_;
            return this;
        }

        public JmenuItemBuilder buid() {
            return new JmenuItemBuilder(this);
        }
    }

    private JmenuItemBuilder(Builder builder) {
        jMenuItem = builder.jMenuItem;
    }
}
