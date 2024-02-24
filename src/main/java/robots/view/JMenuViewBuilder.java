package robots.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JMenuViewBuilder {
    public JMenu jMenu;

    public static class Builder{
        public JMenu jMenu;

        public Builder jMenu(JMenu jMenu_) {
            jMenu = jMenu_;
            return this;
        }

        public Builder setMnemonic(int ketEvent){
            jMenu.setMnemonic(ketEvent);
            return this;
        }
        public Builder setAccessibleDescription(String text){
            jMenu.getAccessibleContext().setAccessibleDescription(text);
            return this;
        }

        public Builder addMenuItem(JMenuItem jMenuItem) {
            jMenu.add(jMenuItem);
            return this;
        }

        public JMenuViewBuilder buid() {
            return new JMenuViewBuilder(this);
        }
    }

    private JMenuViewBuilder(Builder builder) {
        jMenu = builder.jMenu;
    }
}
