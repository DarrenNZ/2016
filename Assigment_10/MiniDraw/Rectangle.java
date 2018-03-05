// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import java.util.*;
import ecs100.*;
import java.awt.Color;
import java.io.*;

/** Rectangle represents a solid rectangle shape
 *   Implements the Shape interface.
 *   Needs fields to record the position, size, and colour
 */

public class Rectangle implements Shape {
    //fields
    private double x1;  // one end
    private double y1;
    private double x2;  // the other end
    private double y2;
    private Color col;

    /** Constructor with explicit values
     *  Arguments are the x and y of the top left corner,
     *  the width and height, and the color. 
     */
    public Rectangle(double x, double y, double x2, double y2, Color col) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x2;
        this.y2 = y2;
        this.col = col;

    }

    /** [Completion] Constructor which reads values from a String
     *  that contains the specification of the Rectangle. 
     *  The format of the String is determined by the toString method.
     *     The first 3 integers specify the color;
     *     the following four numbers specify the position and the size.
     */
    public Rectangle(String description) {
        Scanner data = new Scanner(description);
        int red = data.nextInt();
        int green = data.nextInt();
        int blue = data.nextInt();
        this.col = new Color(red, green, blue);
        this.x1 = data.nextDouble();
        this.y1 = data.nextDouble();
        this.x2 = data.nextDouble();
        this.y2 = data.nextDouble();

    }

    /** Returns true if the point (u, v) is on top of the shape */
    public boolean on(double u, double v) {
        double threshold = 3;
        //u,x
        //v,y
        if (u < Math.min(this.x1,this.x2)-threshold ||     
        u > Math.max(this.x1,this.x2)+threshold ||
        v < Math.min(this.y1,this.y2)-threshold ||
        v > Math.max(this.y1,this.y2)+threshold) {
            return false;
        }
        return true;
    }

    public void moveBy(double dx, double dy) {
        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;

    }

    /** Draws the rectangle on the graphics pane. 
     *  It draws a black border and fills it with the color of the rectangle.
     */
    public void redraw() {
        UI.setColor(this.col);
        //UI.drawRect(this.x, this.y, this.wd, this.ht);

        double bX = this.x1;
        double sX = this.x2;
        if (x1<x2){bX=x2; sX=x1;}

        double bY = this.y1;
        double sY = this.y2;
        if (y1<y2){bY=y2; sY=y1;}

        double width = bX - sX;
        double height = bY - sY;

        //pressedx = x1;
        //pressedy y1;
        //x = x2released;
        //y = x2realeased;

        //this.x1 replaces this.pressX
        //this.y1 replaces this.pressy
        //this.x2 replaces x
        //this.y2 replaces y

        if (this.x2<this.x1 && this.y2 < this.y1){
            UI.fillRect(this.x1-width, this.y1-height, width, height);
        }
        else if (this.x2<this.x1 && this.y2> this.y1){
            UI.fillRect(this.x1-width, this.y1, width, height);
        }
        else if (this.x2>this.x1 && this.y2< this.y1){
            UI.fillRect(this.x1, this.y1-height, width, height);
        }
        else {
            UI.fillRect(this.x1, this.y1, width, height);
        }

    }

    /** [Completion] Changes the width and height of the shape by the
     *  specified amounts.
     *  The amounts may be negative, which means that the shape
     *  should get smaller, at least in that direction.
     *  The shape should never become smaller than 1 pixel in width or height
     *  The center of the shape should remain the same.
     */
    public void resize (double changeWd, double changeHt) {
       if (this.x1 < this.x2){
            this.x1 = this.x1 - changeWd/2;
            this.x2 = this.x2 + changeWd/2;
        }
        else{
            this.x1 = this.x1 + changeWd/2;
            this.x2 = this.x2 - changeWd/2;
        }
        if (this.y1 < this.y2){
            this.y1 = this.y1 - changeHt/2;
            this.y2 = this.y2 + changeHt/2;
        }
        else{
            this.y1 = this.y1 + changeHt/2;
            this.y2 = this.y2 - changeHt/2;
        }

    }

    /** Returns a string description of the rectangle in a form suitable for
     *  writing to a file in order to reconstruct the rectangle later
     *  The first word of the string must be Rectangle 
     */
    public String toString() {
        //
        return ("Rectangle "+col.getRed()+" "+col.getGreen()+" "+col.getBlue()+" "+this.x1+" "+this.y1+" "+this.x2+" "+this.y2);
        // to make this class compile. PLEASE FIX THIS LINE
    }

}
