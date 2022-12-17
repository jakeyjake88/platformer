package org.example;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage img;
    private BufferedImage imgJake;
    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        importImg();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        setPanelSize();
        addMouseMotionListener(mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("resized-andy.png");
        InputStream isTwo = getClass().getResourceAsStream("resized-jake.png");
        try {
            img = ImageIO.read(is);
            imgJake = ImageIO.read(isTwo);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        repaint();
        Toolkit.getDefaultToolkit();

    }

    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit.getDefaultToolkit().sync();
        g.drawImage(img, 0, 0, null);
        g.drawImage(imgJake, 40, 40, null);
    }
}
