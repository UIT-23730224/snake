package src;

import java.util.Random;

public class ObjectManager {
  private static final int WIDTH = 500;
  private static final int HEIGHT = 500;
  private static final int UNIT_SIZE = 20;
  private static final int NUMBER_OF_UNITS = (WIDTH * HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
  
  private final int[] x = new int[NUMBER_OF_UNITS];
  private final int[] y = new int[NUMBER_OF_UNITS];
  
  private int snakeLength;
  private int foodEaten;
  private int foodX;
  private int foodY;
  private boolean running;
  private Random random;
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



  public int getSnakeX(int index) { return x[index]; }
  public int getSnakeY(int index) { return y[index]; }
  public int getSnakeLength() { return snakeLength; }
  public int getFoodEaten() { return foodEaten; }
  public int getFoodX() { return foodX; }
  public int getFoodY() { return foodY; }
  public char getDirection() { return direction; }
  public void setDirection(char direction) { this.direction = direction; }
  public boolean isGameRunning() { return running; }
}
