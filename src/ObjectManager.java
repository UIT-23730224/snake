package src;

import java.util.Random;

public class ObjectManager {

  private char direction;

  public void moveSnake(){
    for (int i = snakeLenght; i > 0; i--){
      x[i] = x[i-1];
      y[i] = y[i-1];
    }
    switch (direction){
      case 'U' -> y[0] = y[0] - UNIT_SIZE;
      case 'D' -> y[0] = y[0] + UNIT_SIZE;
      case 'L' -> x[0] = x[0] - UNIT_SIZE;
      case 'R' -> x[0] = x[0] + UNIT_SIZE;       
    }
    
  }




  public char getDirection() {
    return direction; 
  }
  public void setDirection(char direction) {
    this.direction = direction;
  }
}
