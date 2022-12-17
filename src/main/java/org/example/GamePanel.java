package org.example;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import inputs.constants.Directions;
import inputs.constants.PlayerConstants;
import inputs.constants.PlayerConstants.*;
import inputs.constants.Directions.*;

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
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = PlayerConstants.IDLE;
    private int playerDir = -1;
    private boolean moving = false;


    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        importImg();
        loadAnimations();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        setPanelSize();
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++) 
            for (int i=0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i*64, j * 40, 64, 40);
            }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) { e.printStackTrace();
         } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void setDirection(int direction) {
        this.playerDir = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void setAnimation() {
        if (moving)
            playerAction = PlayerConstants.RUNNING;
        else
            playerAction = PlayerConstants.IDLE;
    }

    private void updatePos() {
        if (moving) {
            switch(playerDir) {
                case Directions.LEFT:
                    xDelta -= 5;
                    break;
                case Directions.UP: 
                    yDelta -= 5;
                    break;
                case Directions.RIGHT: 
                    xDelta += 5;
                    break;
                case Directions.DOWN: 
                    yDelta += 5;
                    break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit.getDefaultToolkit().sync();
        
        updateAnimationTick();
        setAnimation();
        updatePos();
        g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta, 256, 160, null);
        
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex ++;
            if (aniIndex >= PlayerConstants.GetSpriteAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }
}
