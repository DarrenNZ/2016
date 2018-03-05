// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 4 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** The program contains two methods for analysing the readings of the level of power usage in a house over the course of a day.
 *  There are several things about the power usage level that a user may be interested in: 
 *    The maximum and the minimum power usage level at any point during the day.
 *    The average power usage level during the day.
 *
 *  The program has two methods.  They both read a sequence of levels from
 *  the user (through the terminal window).
 *  One prints a report about the levels; the other plots a graph.
 */
public class PowerAnalyser{

    /**
     * analyseLevels reads a sequence of levels from the user  and prints out
     *    maximum, minimum, and average level.
     *    
     * The sequence is terminated by any word (non-number) such as "done" or "end".
     * All the levels are integers between 0 and 8000. 
     * The method will need variables to keep track of various quantities, all of which 
     * need to be initialised to an appropriate value.
     * It will need a loop to keep reading the levels until there isn't an integer next.
     * [Core]
     *   - There is guaranteed to be at least one level,
     *   - Print the maximum, minimum, and average level
     *   - Hint, keep track of the sum of the levels using a variable of type double
     */
    public void analyseLevels() {
        UI.clearText();
		int min = 8000;
		int max = 0;
		int avg = 0;
        int total = 0;
        int count = 0;
        int var = 0;
        UI.println("Please insert quantites, then insert 'done' when complete");
        
		while(UI.hasNextInt()){
		  var = UI.nextInt();
		  total+= var;
		  UI.println(var);
		  count++;
		  avg = total/count;
		  if (var > max){max = var;}
		  if (var < min){min = var;}
		  }
        
        UI.println("average is: "+ avg + " Maximun is: " + max+ " minimum is: " + min);
        UI.nextLine(); // to clear out the input
    }

    /**
     * Reads a sequence of levels (integers) from the user (using Scanner
     * and the terminal window) and plots a bar graph of them, using narrow 
     * rectangles whose heights are equal to the level.
     * The sequence is terminated by any word (non-number) such as "done" or "end".
     * The method may assume that there are at most 24 numbers.
     * The method will need a loop to keep reading the levels until there isn't a number next.
     *  Each time round the loop, it needs to read the next level and work out where
     *  to draw the rectangle for the bar. 
     * [Completion]
     *   - The method should work even if there were no readings for the day.
     *   - Any level greater than 8000 should be plotted as if it were just 8000, putting an
     *         asterisk ("*") above it to show that it has been cut off.
     *   - Draws a horizontal line for the x-axis (or baseline) without any labels.
     * [Challenge:] 
     *   - The graph should also have labels on the axes, roughly every 50 pixels.
     *   - Make the method ask for a maximum level first, then scale the y-axis and values 
     *     so that the largest numbers just fit on the graph.
     *   - The numbers on the y axis should reflect the scaling.
     */
    public void plotLevels() {
        UI.clearText();
        UI.clearGraphics();
        //  Initialise variables and prompt for input
        // Loop, reading numbers and drawing bars

		int left = 50;
		int top = 50;
		int size = 400;
        int var = 0;
        UI.println("Please insert quantites, then insert 'done' when complete");
        UI.drawRect(left, top, size, size);
        
		if (!UI.hasNextInt()){
		    UI.println("No readings today sorry!");
		  }
        while(UI.hasNextInt()){
		  var = UI.nextInt()*8/10;
		  if (var > 400){
		      var = 400;
		      UI.drawString("*", left, top);
		  }
		  
		  UI.drawRect(left, top+size-var, 5, var);
		  left+= 10;
		  }
        
        UI.nextLine(); // to clear out the input
        UI.println("Done");
    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public PowerAnalyser(){
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("Analyse Levels", this::analyseLevels );
        UI.addButton("Plot Levels Completion", this::plotLevels );
        UI.addButton("Quit", UI::quit );
    }


}
