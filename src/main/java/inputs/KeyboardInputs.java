package inputs;

import org.example.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import inputs.constants.Directions.*;

public class KeyboardInputs implements KeyListener  {
    GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_D:
                gamePanel.setDirection(constants.Directions.RIGHT);
                break;
            case KeyEvent.VK_A:
                gamePanel.setDirection(constants.Directions.LEFT);
            break;
            case KeyEvent.VK_W:
                gamePanel.setDirection(constants.Directions.UP);
                break;
            case KeyEvent.VK_S:
                gamePanel.setDirection(constants.Directions.DOWN);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_D:
            case KeyEvent.VK_A:
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
                gamePanel.setMoving(false);
                break;
        }
    }
}
