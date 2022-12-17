package org.example;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();
        setPanelSize();
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize()
    }
}
