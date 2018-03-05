// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 1, COMP 102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** A very simple program that prints out a name in two different ways*/
public class NamePrinter {


    /**
     * Constructor: Set up the GUI and the buttons
     */
    public NamePrinter(){
        UI.initialise();                            // initialise the UI window.
        UI.addButton("Print", this::printNameTag ); // make buttons and specify
        UI.addButton("Draw", this::drawNameTag );   // what actions they do.
        UI.addButton("Nameplate Size", this:: namePlate);
        UI.addButton("Quit", UI::quit );
    }


  /**
   * Print a nametag with a name inside a box made of asterisks
   */
  public void printNameTag() {
      UI.clearText();                 // clears the text pane
      String name = UI.askString("What is your name");
      UI.println("*********************************");  //UI.println("*********************************");
      UI.println("*                               *");  //UI.println("*         " + name +"            ");
      UI.println("*  HELLO, my name is            *");  //UI.println("*********************************");
      UI.println("*                               *");
      UI.println("*          " + name + "               *");
      UI.println("*                               *");
      UI.println("*********************************");
      UI.println();
     
  }


  /**
   * Draw a nametag on the graphics pane
   *  The rectangular nametag is 300 units wide and 150 units high
   *  and the left edge is 100 units over and the top is 70 units down
   */
    public void drawNameTag(){
        UI.clearGraphics();// clears the graphics pane
        String name = UI.askString("What name do you want on your tag?");
        String School = UI.askString("What School do you go too");
        UI.setFontSize(24);
        UI.fillOval(0, 50, 270, 130);                // draws the outline of a rectangle
        UI.setColor(Color.blue);
        UI.drawString("Hello, my name is" + " " + name, 50, 120);  // puts the string near the top
        //UI.drawString(name,  60, 110);
        UI.drawString("I attend " + School, 60,160);// puts the name near the center
        
        UI.drawImage("C:/profile.jpg", 350, 50, 30, 30);
        UI.setFontSize(12);
        UI.drawRect(350, 50, 150, 75);                // draws the outline of a rectangle
        UI.setColor(Color.yellow);
        UI.drawString("Hello, my name is" + " "+name, 360, 100);  // puts the string near the top
        //UI.drawString(name,  545, 300);
        UI.drawString("I attend " + School, 360,120);// puts the name near the center
    }

    public void namePlate(){
        double width = UI.askDouble("How wide would you like your name plate");
        double height = UI.askDouble("How tall would you like your name plate");
        String Name = UI.askString("What is your full name?");
        String school = UI.askString("What school do you go to?");
        UI.drawRect(50,200,width, height);
        UI.drawString("Welcome " + Name + " to " + school, 60, 210);
    }

}
