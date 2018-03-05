// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** The snake is created at a random position with a random direction.
 * The constructor does not have any parameters.
 * It can move
 *  - makes it go forward one step in its current direction.
 *  - if outside arena boundaries, makes it go backward one step, and then turn to a new (random)
 *         direction.
 *  The walls of the arena are determined by the constants:
 *    FrogSnakeGame.TopWall, FrogSnakeGame.BotWall, FrogSnakeGame.LeftWall and FrogSnakeGame.RightWall
 * It can report its current position (x and y) with the
 *  getX() and getY() methods.
 *  draw() will make it draw itself,
 *  erase() will make it erase itself
 */

public class Snake{
    public String dir; 
    public static final int ArenaSize = 400;
    public static final int LeftWall = 30;
    public static final int RightWall = LeftWall+ArenaSize;
    public static final int TopWall = 50;
    public static final int BotWall = TopWall+ArenaSize;
    public double x = LeftWall + Math.random()*RightWall;//30//430
    public double y = TopWall + Math.random()*BotWall;//50//450
    public double random = 1+(Math.random()*4);
    public double snakeSpeed = 2.0;
    public void snake(){
        //

    }
	public void snakeSpeed(double snSpeed){
	   this.snakeSpeed = snSpeed;
	   }
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void move(){//need to make it so snake reappear random not change direction.
        //need be able to run into frogs and make them small again.
        if (y<FrogGame.TopWall){
            this.random= 1+(Math.random()*4);
            //this.y = FrogGame.TopWall;
            this.newSnake();
        }
        if (y>FrogGame.BotWall-30) {
            this.random = 1+(Math.random()*4);
            //this.y = FrogGame.BotWall-30;
            this.newSnake();
        }//y = FrogGame.BotWall-(30+this.sizeGrow);}
        if (x<FrogGame.LeftWall){
            this.random = 1+(Math.random()*4);
            //this.x = FrogGame.LeftWall;
            this.newSnake();
        }//x = FrogGame.LeftWall;}
        if (x>FrogGame.RightWall-30){
            this.random = (Math.random()*4);
            //this.x = FrogGame.RightWall-30;
            this.newSnake();
        }//x = FrogGame.RightWall-(30+this.sizeGrow);}
        if (this.random <= 1){
            this.dir = "Up";
            this.y = this.y - this.snakeSpeed;
        }
        else if (this.random <=2){
            this.dir="Down";
            this.y = this.y + this.snakeSpeed;
        }
        else if(this.random <=3){
            this.dir="Left";
            this.x = this.x - this.snakeSpeed;
        }
        else{
            this.dir="Right";
            this.x = this.x + this.snakeSpeed;
        }

    }

    public void draw(){
        this.erase();

        UI.drawImage("snake.jpg", this.x, this.y, 30, 30);

    }

    public void newSnake(){
        this.erase();
        this.x = LeftWall + 15 + Math.random()*(ArenaSize-15);
        this.y = TopWall + 15 + Math.random()*(ArenaSize-15);
        UI.drawImage("snake.jpg", this.x, this.y, 30, 30);
    }

    public void erase(){
        Snake snake = new Snake();
        snake = null;
    }
}
