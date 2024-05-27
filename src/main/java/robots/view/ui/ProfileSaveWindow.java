package robots.view.ui;

import robots.model.helpz.profileManager;
import robots.model.i18n.I18nBundles;
import robots.model.i18n.I18nProvider;
import robots.view.AbstractWindow;
import robots.view.MainApplicationFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProfileSaveWindow extends JFrame {
    public ProfileSaveWindow(MainApplicationFrame screen) {
        setResizable(false);
        JPanel contents = new JPanel();
        JButton btnConfirm1 = new JButton(I18nProvider.getProfileWindowMessage("Profile1"));
        JButton btnConfirm2 = new JButton(I18nProvider.getProfileWindowMessage("Profile2"));
        JButton btnConfirm3 = new JButton(I18nProvider.getProfileWindowMessage("Profile3"));
        JButton btnDelete1 = new JButton(I18nProvider.getProfileWindowMessage("DELProfile1"));
        JButton btnDelete2 = new JButton(I18nProvider.getProfileWindowMessage("DELProfile2"));
        JButton btnDelete3 = new JButton(I18nProvider.getProfileWindowMessage("DELProfile3"));
        JButton btnConfirm4 = new JButton(I18nProvider.getProfileWindowMessage("ExitWithNoSave"));
        JButton btnCancel = new JButton(I18nProvider.getProfileWindowMessage("Cancel"));

        Object[] options = {I18nProvider.getProfileWindowMessage("YES"), I18nProvider.getProfileWindowMessage("NO")};

        btnConfirm1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileManager.setCurrentProfile("1");
                if (!profileManager.isGameWindowIsClosed() && profileManager.isNotChoosingProfileState()) {
                    profileManager.setGameWindowPos(screen.getGameWindowPos());
                }
                if (!profileManager.isLogWindowIsClosed() && profileManager.isNotChoosingProfileState()) {
                    profileManager.setLogWindowPos(screen.getLogWindow().getLocationOnScreen());
                    profileManager.setCurrentLog(screen.getLogWindow().getLogText());
                }
                profileManager.WriteToFile();
                dispose();
                screen.globalClose();
                screen.dispose();
                System.exit(0);
            }
        });

        btnConfirm2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileManager.setCurrentProfile("2");
                if (!profileManager.isGameWindowIsClosed() && profileManager.isNotChoosingProfileState()) {
                    profileManager.setGameWindowPos(screen.getGameWindowPos());
                }
                if (!profileManager.isLogWindowIsClosed() && profileManager.isNotChoosingProfileState()) {
                    profileManager.setLogWindowPos(screen.getLogWindow().getLocationOnScreen());
                    profileManager.setCurrentLog(screen.getLogWindow().getLogText());
                }
                profileManager.WriteToFile();
                dispose();
                screen.globalClose();
                screen.dispose();
                System.exit(0);
            }
        });

        btnConfirm3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profileManager.setCurrentProfile("3");
                if (!profileManager.isGameWindowIsClosed() && profileManager.isNotChoosingProfileState()) {
                    profileManager.setGameWindowPos(screen.getGameWindowPos());
                }
                if (!profileManager.isLogWindowIsClosed() && profileManager.isNotChoosingProfileState()) {
                    profileManager.setLogWindowPos(screen.getLogWindow().getLocationOnScreen());
                    profileManager.setCurrentLog(screen.getLogWindow().getLogText());
                }
                profileManager.WriteToFile();
                dispose();
                screen.globalClose();
                screen.dispose();
                System.exit(0);
            }
        });

        btnConfirm4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                screen.globalClose();
                screen.dispose();
                System.exit(0);
            }
        });

        btnDelete1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showOptionDialog(
                        null,
                        I18nProvider.getProfileWindowMessage("USURE?"),
                        I18nProvider.getProfileWindowMessage("CONFIRM"),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[1]
                );
                if (result == JOptionPane.YES_OPTION) {
                    profileManager.deleteFile("1");
                }
            }
        });

        btnDelete2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showOptionDialog(
                        null,
                        I18nProvider.getProfileWindowMessage("USURE?"),
                        I18nProvider.getProfileWindowMessage("CONFIRM"),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[1]
                );
                if (result == JOptionPane.YES_OPTION) {
                    profileManager.deleteFile("2");
                }
            }
        });

        btnDelete3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showOptionDialog(
                        null,
                        I18nProvider.getProfileWindowMessage("USURE?"),
                        I18nProvider.getProfileWindowMessage("CONFIRM"),
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[1]
                );
                if (result == JOptionPane.YES_OPTION) {
                    profileManager.deleteFile("3");
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    dispose();
                    screen.globalClose();
                    screen.dispose();
                    System.exit(0);
                }
            });

        contents.add(btnConfirm1);
        contents.add(btnConfirm2);
        contents.add(btnConfirm3);
        contents.add(btnConfirm4);
        contents.add(btnDelete1);
        contents.add(btnDelete2);
        contents.add(btnDelete3);
        contents.add(btnCancel);


        setContentPane(contents);
    }
}
