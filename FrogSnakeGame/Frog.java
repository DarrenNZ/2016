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

/** Frog
 *  A new frog starts at the given position, with the given direction, and 
 *     has either a "light" or "dark" shade.
 *  Frogs can turn in 4 directions: left, right, up, and down. 
 *  Frogs move around at a constant speed in an arena with an enclosing wall,
 *     following its direction, until it hits a wall. In which case it stops moving.
 *  Frog can grow in size, and (for the completion) can also shrink by resetting their size
 *      to the orginal value.
 *
 *  The walls of the arena are determined by the constants:
 *    FrogGame.TopWall, FrogGame.BotWall, FrogGame.LeftWall and FrogGame.RightWall
 */

public class Frog {
    // Constants
    public static final int INITIAL_SIZE = 30;
    public static final int GROWTH_RATE = 1;
    public static final int SPEED = 2;
	
    // Fields

    public double x;
    public double y;
    public String direction;
    public String lightDark;
    public int mosCount;
    public int sizeGrow = 0;
    public int hop = 0; // puts counter on draw method to make frog hop
    public double xhop = 0;
    public double yhop = 0;

    //Constructor 
    /** 
     * Make a new frog
     * The parameters specify the initial position of the top left corner,
     *   the direction, and the shade of the Frog ("light" or "dark")
     * We assume that the position is within the boundaries of the arena
     */
    public Frog(double left, double top, String dir, String shade)  {
        this.x = left;
        this.y = top;
        this.direction = dir;
        this.lightDark = shade;
        draw();
    }

    /**
     * Turn right
     */
    public void turnRight(){
        this.direction = "Right";

    }

    /**
     * Turn left
     */
    public void turnLeft(){
        this.direction = "Left";

    }

    /**
     * Turn up
     */
    public void turnUp(){
        this.direction = "Up";

    }

    /**
     * Turn down
     */
    public void turnDown(){
        this.direction = "Down";

    }

    /**
     * Moves the frog: 
     *   use SPEED unit forward in the correct direction
     *   by changing the position of the frog.
     * Make sure that the frog does not go outside the arena, by making sure 
     *  - the top of the frog is never smaller than FrogGame.TopWall
     *  - the bottom of the frog is never greater than FrogGame.BotWall
     *  - the left of the frog is never smaller than FrogGame.LeftWall
     *  - the right of the frog is never smaller than FrogGame.RightWall
     */
    public void move() {


        if (this.direction.equals("Up")){
            this.y = this.y - this.SPEED;
        }
        else if (this.direction.equals("Left")) {
            this.x = this.x - this.SPEED;
        }
        else if (this.direction.equals("Right")){
            this.x = this.x + this.SPEED;
        }
        else {
            this.y = this.y + this.SPEED;
        }

        if (y<FrogGame.TopWall){y = FrogGame.TopWall;}
        if (y>FrogGame.BotWall-(30+this.sizeGrow)) {y = FrogGame.BotWall-(30+this.sizeGrow);}
        if (x<FrogGame.LeftWall){x = FrogGame.LeftWall;}
        if (x>FrogGame.RightWall-(30+this.sizeGrow)){x = FrogGame.RightWall-(30+this.sizeGrow);}

    }

    /**
     * Check whether the frog is touching the given point, eg, whether the
     *   given point is included in the area covered by the frog.
     * Return true if the frog is on the top of the position (x, y)
     * Return false otherwise
     */
    public boolean touching( double x, double y) {
        //measures from top left of frog, needs to be center
        double bx = this.x + ((this.INITIAL_SIZE+this.sizeGrow)/2);
        double sx = x;
        double by = this.y + ((this.INITIAL_SIZE+this.sizeGrow)/2);
        double sy = y;
        if (bx < x){
            sx = bx;
            bx = x;
        }
        if (by < y){
            sy = by;
            by = y;
        }

        if ((bx - sx < INITIAL_SIZE + this.sizeGrow) && (by - sy < INITIAL_SIZE + this.sizeGrow)){
            return true;
        }
        else {return false;}
    }

    /**
     * The Frog has just eaten a bug
     * Makes the frog grow larger by GROWTH_RATE.
     */
    public void grow(){
        /*# YOUR CODE HERE */
        this.sizeGrow+=2;

    }

    /**
     * The Frog has just bumped into a snake
     * Makes the frog size reset to its original size
     * ONLY NEEDED FOR COMPLETION
     */
    public void shrink(){

        this.sizeGrow = 0;
        this.draw();
    }

    /**
     * Draws the frog at the current position.
     */
    public void draw(){
        
        
        if (this.hop == 0){
            UI.drawImage(lightDark + "frog.jpg", this.x, this.y, this.INITIAL_SIZE + this.sizeGrow, this.INITIAL_SIZE + this.sizeGrow);
            this.xhop = this.x;
            this.yhop = this.y;
            this.hop=10;
        }
            else {
                UI.drawImage(lightDark + "frog.jpg", this.xhop, this.yhop, this.INITIAL_SIZE + this.sizeGrow, this.INITIAL_SIZE + this.sizeGrow);
                this.hop-=2;
            
        }
    }
}

