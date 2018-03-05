// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 3, COMP102 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** The NewObjectsExercise class has several simple methods
that involve creating new objects and calling methods on those objects.
- flowers() should create two or three Flower objects and
make them grow and bloom
- balloons() should create two Balloon objects and
make them expand and pop
- bankAccounts() should create two BankAccount objects and
deposit to, withdraw from, and print statements of them
- cars() should create two Car objects and make them
drive towards each other then turn to the side and drive some more
- studentMarks() should create two StudentMarkRecord objects and record
several marks for each student and display their current assignment status
 */

public class NewObjectsExercise {

    /** Creates two or three Flower objects and makes them grow and bloom */
    public void flowers(){

	public class Flower{
    //Fields
    private double baseX;             // location of the center of the base of the flower
    private double baseY;
    private double height;            // current height of the stalk, from base of stalk to the center of the bud/flower
    private boolean blooming;      // whether it is in flower or not
  

    /** Construct a new Flower object; parameters are the initial position of the flower.
        Makes a new Flower and draws it.*/
    public Flower(double x, double y){
        this.baseX = x;
        this.baseY = y;
        this.blooming = false;
        this.height = 20;
        this.draw();        
    }
    /** Makes the flower taller.
        It first erases the flower, then
        changes the height by the specified amount, and then
        redraws the flower .*/
    public void grow(double step){
        this.erase();
        this.height = this.height + step;
        this.draw();
    }

    /** Makes the flower bloom, 
        It first erases the flower, then
        changes the state, and then draws the flower again.
    */
    public void bloom(){
        this.erase();
        this.blooming = true;
        this.draw();
    }


    /** Draws the flower on the graphics pane.
        It needs to draw a narrow solid green rectangle of the right height
        from the base of the flower. Then, depending on whether the stage of the flower
        is "Bud",  "Bloom", or "Picked", it should draw a small green circle, or a big
        red circle, or no circle at all.
    */
    
    private void draw(){
        UI.setColor(Color.green);
        UI.fillRect(this.baseX-2, this.baseY - this.height, 5, this.height);
      
        if ( this.blooming) {
            UI.setColor(Color.red);
            UI.fillOval(this.baseX-20, this.baseY-this.height-20, 40, 40);
        }
        else {
            UI.setColor(Color.green);
            UI.fillOval(this.baseX-10, this.baseY-this.height-10, 20, 20);
        }
        UI.sleep(1000);
    }


    /** Erases the flower, so that it can be redrawn.
    */
    public void erase(){
        UI.eraseRect(this.baseX-2, (this.baseY - this.height), 5, this.height);
        double radius = 10;
        if ( this.blooming) {
            radius = 20;
        }
        UI.eraseOval(this.baseX-radius, this.baseY-this.height-radius, 2*radius, 2*radius);
    }


}

    }

    /** Creates two Balloon objects and makes them expand and pop */
    public void balloons(){
        /*# YOUR CODE HERE */

    }

    /** Creates two BankAccount objects and deposits to, withdraws from, and
     * prints statements of them
     */
    public void bankAccounts(){
        /*# YOUR CODE HERE */

    }

    /**  Creates two Car objects and makes them         drive towards
     *  each other then turn to the side and drive some more.
     */
    public void cars(){
        /*# YOUR CODE HERE */

    }

    /** Creates two StudentMarkRecord objects and records several marks
    for each student and displays their current assignment status.
     */
    public void studentMarks(){
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/

    /** Constructor to set up the user interface */
    public NewObjectsExercise(){
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("Flowers", this::flowers );
        UI.addButton("Balloons", this::balloons );
        UI.addButton("Bank Accounts", this::bankAccounts );
        UI.addButton("Cars", this::cars );
        UI.addButton("Student Marks", this::studentMarks );
        UI.addButton("Quit", UI::quit );
    }


}
