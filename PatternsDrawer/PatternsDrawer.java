// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 4, 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** PatternsDrawer
Draw various patterns. */

public class PatternsDrawer{

    public static final double boardLeft = 50;   // Top left corner of the board
    public static final double boardTop = 50;
    public static final double boardSize = 300;  // The size of the board on the window

    /** Draw a square grid board with white squares.
     *  Asks the user for the number of squares on each side
     *
     * CORE
     */
    public void drawGridBoard(){
        UI.clearGraphics();
        double left = 0.00;
        double top = 0.00;
        double num = UI.askInt("How many rows:");
        double num1 = num;
        double num2 = num;

        while(num1 > 0)
        {
            UI.drawRect(boardLeft+left,boardTop, 5, 5);

            while(num2>0){
                UI.drawRect(boardLeft+left, boardTop+top, 5, 5);
                top+=5;

                num2--;  
            }
            top = 0;
            left += 5;
            num2 = num; 
            num1--;
        }
    }

    /** Illusion
     * a pattern that makes dark circles appear in the intersections
     * when you look at it. 
     **/
    public void drawIllusion(){
        UI.clearGraphics();
        double left = 0.00;
        double top = 0.00;
        double num = UI.askInt("How many rows:");
        double num1 = num;
        double num2 = num;

        while(num1 > 0)
        {
            UI.drawRect(boardLeft+left,boardTop, 5, 5);

            while(num2>0){
                UI.drawRect(boardLeft+left, boardTop+top, 5, 5);
                top+=5;

                num2--;  
            }
            top = 0;
            left += 5;
            num1--;
            num2 = num1; 

        }   

    }

    /** Draw a checkered board with alternating black and white squares
     *    Asks the user for the number of squares on each side
     *
     * COMPLETION
     */
    public void drawCheckersBoard(){
        UI.clearGraphics();
        double left = 0;
        double top = 0;
        double num = 11;
        num*=5;
        boolean black = false;

        while(left<num)
        {
            top = 0;
            while(top<num)
            {
                if (black){
                    UI.fillRect(boardLeft+left, boardTop+top, 5, 5);
                    black = false;
                }
                else {
                    //UI.drawRect(boardLeft+left, boardTop, 5, 5);
                    black = true;
                }
                top+=5;   
            }
            left += 5;
        }
    }

    /** Draw a board made of concentric circles, 2 pixel apart
     *  Asks the user for the number of squares on each side
     */
    public void drawConcentricBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:");
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/

    public PatternsDrawer(){
        UI.initialise();
        //UI.addButton("Clear",UI::clearPanes);
        UI.addButton("Core: Grid", this::drawGridBoard);
        UI.addButton("Core: Illusion", this::drawIllusion);
        UI.addButton("Completion: Checkers", this::drawCheckersBoard);
        UI.addButton("Challenge: Concentric", this::drawConcentricBoard);
        UI.addButton("Quit",UI::quit);
    }   

}
