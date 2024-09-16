package src;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHanler extends KeyAdapter {
  private ObjectManager  objectManager;

  public InputHandler(ObjectManager objectManager){
    this.objectManager = objectManager;
  }
  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        if (objectManager.getDirection() != 'R') {
            objectManager.setDirection('L');
        }
        break;
      case KeyEvent.VK_RIGHT:
        if (objectManager.getDirection() != 'L') {
            objectManager.setDirection('R');
        }
        break;
      case KeyEvent.VK_UP:
        if (objectManager.getDirection() != 'D') {
            objectManager.setDirection('U');
        }
        break;
      case KeyEvent.VK_DOWN:
        if (objectManager.getDirection() != 'U') {
            objectManager.setDirection('D');
        }
        break;
    }
  }
}
