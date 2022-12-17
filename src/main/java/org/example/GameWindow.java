package org.example;

import javax.swing.*;

public class GameWindow extends JFrame {
    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();
        jFrame.setSize(400, 400);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
