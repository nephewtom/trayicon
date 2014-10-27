package org.tom.trayicon;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

    private static String HEART_FILEPATH = ".\\icons\\heart\\shapes\\shape";
    private static String PNG_EXTENSION = ".png";

    public static void main(String[] args) {

        if (!SystemTray.isSupported()) {
            System.out.println("System tray is not supported !!! ");
            return;
        }

        List<Image> images = new ArrayList<Image>();
        for (int i = 0; i < 5; i++) {

            String filePath = HEART_FILEPATH + i + PNG_EXTENSION;
            Image image = Toolkit.getDefaultToolkit().getImage(filePath);
            images.add(image);
        }

        // Menu items, actions & PopupMenu
        MenuItem actionItem = new MenuItem("Action");
        actionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Action Clicked");
            }
        });

        MenuItem closeItem = new MenuItem("Close");
        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        PopupMenu popup = new PopupMenu();
        popup.add(actionItem);
        popup.add(closeItem);

        TrayIcon trayIcon = new TrayIcon(images.get(0), "Tray Demo", popup);
        trayIcon.addMouseListener(new TrayIconListener(trayIcon, images));
        trayIcon.setImageAutoSize(true);

        SystemTray systemTray = SystemTray.getSystemTray();
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println(e);
        }
        // ...
    }
}
