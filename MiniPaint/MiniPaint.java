// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 6
 * Name:Darren Carroll  
 * Usercode:
 * ID:300301318
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

public class MiniPaint{

    // fields to remember:
    //  - the shape that will be drawn when the mouse is next released.
    //  - whether the shape should be filled or not
    //  - the position the mouse was pressed, 
    //  - the name of the image file
    public String shape;
    public boolean fill = false;
    public double pressX, pressY, dragX, dragY;
    public String imageFile;
    public Color color = Color.black;
    boolean pencil = false;
    boolean rubber = false;

    //Constructor
    /** Sets up the user interface - mouselistener and buttons */
    public MiniPaint(){

        //UI.addButton("clear", system.out.clearGraphics);
        UI.addButton("clear", UI::clearGraphics);
       // UI.addButton("line", this.lineMethod);
        UI.addButton("rect", this::rectMethod);
        UI.addButton("Oval", this::ovalMethod);
        UI.addButton("image", this::imageMethod);
        UI.addButton("color", this::colorMethod);
        UI.addButton("fill", this::fillMethod);
        UI.addButton("Challange Pencil", this::pencil);
        UI.addButton("Challange rubber", this::rubber);
        UI.addButton("Quit", UI::quit);
        //UI.setMouseListener(this::doMouse);**/
        UI.setMouseMotionListener(this::doMotionMouse);
        UI.addButton("line",this::lineMethod);
       UI.addButton("clear", UI::clearGraphics);
    }

    public void pencil(){
        if (this.pencil){
            this.pencil = false;
        }
        else{
            this.pencil = true;
            this.rubber = false;
        }

    }
	public void rubber(){
	   if(this.rubber){
	   this.rubber = false;
	   }
	   else{
	   this.rubber = true;
	   this.pencil = false;
	   }
	   }
    public void lineMethod(){
        this.shape = "line";
        this.pencil = false;
        this.rubber = false;
    }

    public void rectMethod(){
        this.shape = "rect";
        this.pencil = false;
        this.rubber = false;
    }

    public void imageMethod(){
        this.shape = "image";
        this.imageFile = "yellowrose2.jpg";
        this.pencil = false;
        this.rubber = false;
    }

    public void ovalMethod(){
        this.shape = "oval";
        this.pencil = false;
        this.rubber = false;
    }

    public void colorMethod(){

        this.color = JColorChooser.showDialog(null, "Choose Color",this.color);
        UI.setColor(this.color);

    }

    public void fillMethod(){
        if (fill){
            fill = false;
        }
        else{ 
            fill = true;
        }
    }

    /**
     * Respond to mouse events
     * When pressed, remember the position.
     * When released, draw the current shape using the pressed position
     *  and the released position.
     * Uses the value in the field to determine which kind of shape to draw.
     * Although you could do all the drawing in this method,
     *  it may be better to call some helper methods for the more
     *  complex actions (and then define the helper methods!)
     */

    public void doMotionMouse(String action, double x, double y){
        if (action.equals("pressed") && pencil){
            this.pressX = x;
            this.pressY = y;
        }
        if (action.equals("dragged") && pencil){
            this.dragX = x;
            this.dragY = y;
            UI.setColor(Color.black);
            UI.drawLine(this.pressX, this.pressY, this.dragX, this.dragY);
            this.pressX = this.dragX;
            this.pressY = this.dragY;
            UI.setColor(this.color);
        }
        if (action.equals("pressed") && rubber){
            this.pressX = x;
            this.pressY = y;
        }
        if (action.equals("dragged")&& rubber){
            this.dragX = x;
            this.dragY = y;
			UI.setColor(Color.white);
			UI.setLineWidth(5.0);
			UI.drawLine(this.dragX, this.dragY, this.pressX ,this.pressY);
			this.pressX = this.dragX;
			this.pressY = this.dragY;
			UI.setColor(this.color);
			UI.setLineWidth(1.0);
        }

        if (action.equals("pressed")){
            this.pressX = x;
            this.pressY = y;
        }
        if (action.equals("released")){
            double bX = this.pressX;
            double sX = x;
            if (this.pressX<x){bX=x; sX=this.pressX;}

            double bY = this.pressY;
            double sY = y;
            if (this.pressY<y){bY=y; sY=this.pressY;}

            double width = bX - sX;
            double height = bY - sY;

            if (shape.equals("line")){UI.drawLine(this.pressX, this.pressY, x, y);}
            if (shape.equals("rect") && !fill){

                if (x<this.pressX && y < this.pressY){
                    UI.drawRect(this.pressX-width, this.pressY-height, width, height);
                }
                else if (x<this.pressX && y> this.pressY){
                    UI.drawRect(this.pressX-width, this.pressY, width, height);
                }
                else if (x>this.pressX && y< this.pressY){
                    UI.drawRect(this.pressX, this.pressY-height, width, height);
                }
                else {
                    UI.drawRect(this.pressX, this.pressY, width, height);
                }
            }
            else if (shape.equals("rect") && fill){
                if (x<this.pressX && y < this.pressY){
                    UI.fillRect(this.pressX-width, this.pressY-height, width, height);
                }
                else if (x<this.pressX && y> this.pressY){
                    UI.fillRect(this.pressX-width, this.pressY, width, height);
                }
                else if (x>this.pressX && y< this.pressY){
                    UI.fillRect(this.pressX, this.pressY-height, width, height);
                }
                else {
                    UI.fillRect(this.pressX, this.pressY, width, height);
                }

            }
            if (shape.equals("image")){

                if (x<this.pressX && y < this.pressY){
                    UI.drawImage(this.imageFile, this.pressX-width, this.pressY-height, width, height);
                }
                else if (x<this.pressX && y> this.pressY){
                    UI.drawImage(this.imageFile, this.pressX-width, this.pressY, width, height);
                }
                else if (x>this.pressX && y< this.pressY){
                    UI.drawImage(this.imageFile, this.pressX, this.pressY-height, width, height);
                }
                else {
                    UI.drawImage(this.imageFile, this.pressX, this.pressY, width, height);
                }
            }    
            if (shape.equals("oval") && !fill){

                if (x<this.pressX && y < this.pressY){
                    UI.drawOval(this.pressX-width, this.pressY-height, width, height);
                }
                else if (x<this.pressX && y> this.pressY){
                    UI.drawOval(this.pressX-width, this.pressY, width, height);
                }
                else if (x>this.pressX && y< this.pressY){
                    UI.drawOval(this.pressX, this.pressY-height, width, height);
                }
                else {
                    UI.drawOval(this.pressX, this.pressY, width, height);
                }
            }
            else if (shape.equals("oval") && fill){
                if (x<this.pressX && y < this.pressY){
                    UI.fillOval(this.pressX-width, this.pressY-height, width, height);
                }
                else if (x<this.pressX && y> this.pressY){
                    UI.fillOval(this.pressX-width, this.pressY, width, height);
                }
                else if (x>this.pressX && y< this.pressY){
                    UI.fillOval(this.pressX, this.pressY-height, width, height);
                }
                else {
                    UI.fillOval(this.pressX, this.pressY, width, height);
                }

            }
        }

    }
    /* Helper methods for drawing the shapes, if you choose to define them 
    I used the following methods:

    public void drawARectangle(double x, double y)
    // draws a Rectangle between the mouse pressed and mouse released points.

    public void drawAnOval(double x, double y)
    // draws a Rectangle between the mouse pressed and mouse released points.

    public void drawAnImage(double x, double y)
    // draws an image at the mouse released point.

     */

    /*# YOUR CODE HERE */

    // Main:  constructs a new MiniPaint object
    public static void main(String[] arguments){
        new MiniPaint();
    }        

}
