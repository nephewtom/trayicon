package org.tom.trayicon;

import java.awt.Image;
import java.awt.TrayIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class TrayIconListener implements MouseListener {

    private TrayIcon trayIcon;
    private List<Image> images;
    private Image currentImage;
    int index = 0;

    TrayIconListener(TrayIcon trayIcon, List<Image> images) {
        this.trayIcon = trayIcon;
        this.images = images;
    }

    public void mouseClicked(MouseEvent e) {
        index++;
        if (index == images.size()) {
            index = 0;
        }
        currentImage = this.images.get(index);
        trayIcon.setImage(currentImage);
    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
