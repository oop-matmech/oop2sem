package robots.view.ui;

import com.sun.tools.javac.Main;
import robots.model.helpz.profileManager;
import robots.model.i18n.I18nProvider;
import robots.model.log.Logger;
import robots.view.AbstractWindow;
import robots.view.MainApplicationFrame;
import robots.view.Menu.CustomJmenuBar;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileWindow extends AbstractWindow {

    private MainApplicationFrame screen;
    public ProfileWindow(MainApplicationFrame screen) {
        super("Выбор профиля", false, true, false, false);
        JPanel contents = new JPanel();
        this.screen = screen;
        JButton btnConfirm1 = new JButton(I18nProvider.getProfileWindowMessage("Profile1"));
        JButton btnConfirm2 = new JButton(I18nProvider.getProfileWindowMessage("Profile2"));
        JButton btnConfirm3 = new JButton(I18nProvider.getProfileWindowMessage("Profile3"));
        JButton btnConfirm4 = new JButton(I18nProvider.getProfileWindowMessage("WithoutProfile"));

        btnConfirm1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileManager.setCurrentProfile("1");
                dispose();
                profileManager.endProfileChoosingSession();
                if(!profileManager.CheckOnProfileFile()) {
                    JOptionPane.showMessageDialog(
                            null,
                            I18nProvider.getProfileWindowMessage("NoProfileFound"));
                    profileManager.setDefaultProfile();
                    profileLoad();
                }
                else {
                    profileManager.restoreMyProfile();
                    profileLoad();
                }
            }
        });

        btnConfirm2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileManager.setCurrentProfile("2");
                dispose();
                profileManager.endProfileChoosingSession();
                if(!profileManager.CheckOnProfileFile()) {
                    JOptionPane.showMessageDialog(
                            null,
                            I18nProvider.getProfileWindowMessage("NoProfileFound"));
                    profileManager.setDefaultProfile();
                    profileLoad();
                }
                else {
                    profileManager.restoreMyProfile();
                    profileLoad();
                }
            }
        });

        btnConfirm3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileManager.setCurrentProfile("3");
                dispose();
                profileManager.endProfileChoosingSession();
                if(!profileManager.CheckOnProfileFile()) {
                    JOptionPane.showMessageDialog(
                            null,
                            I18nProvider.getProfileWindowMessage("NoProfileFound"));
                    profileManager.setDefaultProfile();
                    profileLoad();
                }
                else {
                    profileManager.restoreMyProfile();
                    profileLoad();
                }
            }
        });

        btnConfirm4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileManager.endProfileChoosingSession();
                dispose();
                profileManager.setDefaultProfile();
                profileLoad();
            }
        });

        contents.add(btnConfirm1);
        contents.add(btnConfirm2);
        contents.add(btnConfirm3);
        contents.add(btnConfirm4);

        setContentPane(contents);
    }

    private void profileLoad(){
        screen.getCustomJmenuBar().switchLocale(profileManager.getCurrentLocale());
        if (!profileManager.isLogWindowIsClosed()){
            screen.getLogWindow().setLocation(profileManager.getLogWindowPos());
            screen.addWindow(screen.getLogWindow());
            screen.getLogWindow().setLogText(profileManager.getCurrentLog());
        }
        if (!profileManager.isGameWindowIsClosed()){
            screen.getGameWindow().setLocation(profileManager.getGameWindowPos());
            screen.addWindow(screen.getGameWindow());
            screen.getGameWindow().startGame(screen);
        }
    }
    @Override
    public void onUiChanged() {
    }

    @Override
    protected void closeWindow() {
    }
}
