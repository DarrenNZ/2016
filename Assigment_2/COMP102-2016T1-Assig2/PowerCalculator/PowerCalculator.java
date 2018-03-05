// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 2 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** Program for calculating how much you can save on your power bill */
// http://www.powerwise.co.nz/why-choose-led-light-bulbs/led-light-bulb-facts/

public class PowerCalculator{

    public static final double priceKWh = 20.34;         // cents
    public static final int incandescentLifeSpan = 1000; // hours
    public static final int ledLifeSpan = 25000;         // hours
    public static final double incadescentPrice = .99;   // dollars

    /** Calculates and prints how long it would take you to amortise your cost of switching
     *  to energy saving bulbs
     */
    public void calculateCostSaverCore(){
        /*# YOUR CODE HERE */

    }

    /** Calculates and prints how long it would take you to amortise your cost of switching
     *  to energy saving bulbs
     *  For the Completion part consider the life span of each type of bulbs and prints
     *  how much saving will be done after numYears years
     *  
     */
    public void calculateCostSaverCompletion(){
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor, sets up the user interface */
    public PowerCalculator(){
        UI.initialise();
        UI.addButton("Core", this::calculateCostSaverCore); 
        UI.addButton("Completion", this::calculateCostSaverCompletion );
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1);    // Expand the Text pane
    }


}
