
// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 7 
 * Name: 
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/**
 * This is related to your program from assignment 4 which analysed polution levels
 * However, instead of reading data from the user, it reads the data from
 * a file into an ArrayList, which means that it can analyse the numbers
 * more easily and in more different ways.
 * It can also cope with much larger sets of numbers.
 * The numbers are guaranteed to be integers but the values can be
 *   negative and the signal swings above and below zero.
 *
 * There are 11 methods you are to complete, all focusing on the ArrayList of data.
 * CORE
 *  doRead:              reads numbers into an ArrayList.
 *  doDisplay:           displays the waveform.
 *  doReportDistortion:  prints out the fraction of time the signal is distorted.
 * COMPLETION
 *  doSpread:            displays the spread with two horizontal lines and returns its value.
 *  doDisplayDistortion: shows in red the distorted part of the signal.
 *  doHighlightPeaks:    plots the peaks with small green circles.
 * CHALLENGE
 *  doNormalise:         normalises all the values down so there is no distortion.
 *  upperEnvelope:       displays the upper envelope.
 *  lowerEnvelope:       displays the lower envelope.
 *  doSave:              saves the current waveform values into a file.
 *  select and edit:     let the user select a regions of the waveform with the mouse
 *                       to remove them.  Add a save button to save the edited values.
 */

public class WaveformAnalyser{
    // Fields 
    private ArrayList<Double> waveform;   // the field to hold the ArrayList of values

    // Constant: the threshold for the distortionLevel and showDistortion methods
    public static final double THRESHOLD = 200;

    // Constants: the dimensions of the graph for the displayWaveform method
    public static final int GRAPH_LEFT = 10;
    public static final int ZERO_LINE = 260;

    // Constant fields holding the size of the circles for the highlightPeaks method
    public static final int SIZE_CIRCLE = 10;

    public double x = 0;
    public double y = 0;
    public double xold = 0;
    public double yold = 0;

    /**
     * [CORE]
     * Clears the panes, 
     * Creates an ArrayList stored in a field, then
     * Asks user for a waveform file (eg waveform1.txt) 
     * Reads data from the file into the ArrayList
     */
    public void doRead(){
        UI.clearPanes();
        String fname = UIFileChooser.open();
        try{
            Scanner sc = new Scanner(new File(fname));
            this.waveform = new ArrayList<Double>();
            while(sc.hasNext()){
                waveform.add(sc.nextDouble());
            }

            UI.println("Read "+ this.waveform.size()+" data points from " + fname);
        }
        catch(Exception e){UI.println("error");}
    }

    /**
     * [CORE]
     * Displays the waveform as a line graph,
     * The n'th value in waveform is displayed at
     *    x-position is GRAPH_LEFT + n
     *    y-position is ZERO_LINE - the value
     * Plots a line graph of all the points with a blue line between
     *  each pair of adjacent points
     * Draw the horizontal line representing the value zero.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * Don't worry if the lines go off the window
     */
    public void doDisplay(){
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();
        //int x = 0;
        int i = 0;
        // draw x axis (showing where the value 0 will be)
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size() , ZERO_LINE); 

        // plot points: blue line between each pair of values
        while (i < waveform.size()){
            UI.setColor(Color.blue);
            this.y = this.waveform.get(i);
            UI.drawLine(this.xold, ZERO_LINE - this.yold, this.x + 1, ZERO_LINE - this.y);
            this.xold = this.x + 1;
            this.yold = this.y;
            this.x+= 1;
            i++;
        }

    }

    /**
     * [CORE]
     * Computes and prints out the fraction of time the signal is distorted. 
     * This fraction of time is defined as the number of distorted values, divided by the number of values. 
     * A distorted value is defined as one whose absolute
     * value is greater than the value of THRESHOLD 
     * [Hint] You may find Math.abs() useful for this method - it computes the absolute value
     */
    public void doReportDistortion() {
        if (this.waveform == null){ //there is no data to analyse
            UI.println("No signal to analyse and report on");
            return;
        }
        double fraction = 0;
        int i = 0;
        double count = 0;
        while(i < waveform.size()){
            if (waveform.get(i) > THRESHOLD || waveform.get(i) < THRESHOLD*-2){count++;}
            i++;
        }
        double y = i;
        fraction = (count/y);
        UI.printf("Fraction of time the signal is distorted %4.3f\n", fraction);
    }

    /**
     * [COMPLETION]
     * The spread is the difference between the maximum and minimum values of the waveform.
     * Finds the maximum and minimum values, then
     * Displays the spread by drawing two horizontal lines on top of the waveform: 
     *   one green line for the maximum value, and
     *   one red line for the minimum value.
     */
    public void doSpread() {
        UI.clearGraphics();

        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }

        double large = 0;
        double small = 900000000;
        int i = 0;
        while(i < waveform.get(i)){
            if (large < waveform.get(i)){
                large = this.waveform.get(i);
            }
            if (small > waveform.get(i)){
                small = waveform.get(i);
            }

            UI.setColor(Color.blue);
            this.y = this.waveform.get(i);
            UI.drawLine(this.xold, ZERO_LINE - this.yold, this.x + 1, ZERO_LINE - this.y);
            this.xold = this.x + 1;
            this.yold = this.y;
            this.x+= 1;

            i++;
        }
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE - large, GRAPH_LEFT + this.waveform.size(), ZERO_LINE - large);
        UI.setColor(Color.red);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE + small, GRAPH_LEFT + this.waveform.size(), ZERO_LINE + small);
        this.doDisplay();
    }

    /**
     * [COMPLETION]  [Fancy version of doDisplay]
     * Display the waveform as a line graph. 
     * Draw a line between each pair of adjacent points
     *   * If neither of the points is distorted, the line is BLUE
     *   * If either of the two end points is distorted, the line is RED
     * Draw the horizontal lines representing the value zero and thresholds values.
     * Uses THRESHOLD to determine distorted values.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * [Hint] You may find Math.abs(int a) useful for this method.
     * You may assume that all the values are between -250 and +250.
     */
    public void doDisplayDistortion() {
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();

        // draw zero axis
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size() , ZERO_LINE); 

        // draw thresholds
        /*# YOUR CODE HERE */

    }

    /**
     * [COMPLETION]
     * Plots the peaks with small green circles. 
     *    A peak is defined as a value that is greater or equals to both its
     *    neighbouring values.
     * Note the size of the circle is in the constant SIZE_CIRCLE
     * You may assume that peaks values differ from their neighbouring points.
     */
    public void doHighlightPeaks() {
        this.doDisplayDistortion(); //use doDisplay if doDisplayDistortion isn't complete
        /*# YOUR CODE HERE */

    }

    /**
     * [CHALLENGE]
     * Finds the largest value (positive or negative) in the waveform, and
     * normalises all the values down so that the largest value is now equal to
     * the distortion threshold.
     * Then redraws the waveform.
     */
    public void doNormalise() {
        /*# YOUR CODE HERE */

        this.doDisplayDistortion(); //use doDisplay if doDisplayDistortion isn't complete
    }

    public void doEnvelope(){
        if (this.waveform == null){ //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        this.doDisplay();  // display the waveform
        this.upperEnvelope();
        this.lowerEnvelope();
    }

    /**
     * [CHALLENGE]
     * Displays the upper envelope with GREEN lines connecting all the peaks.
     *    A peak is defined as a point that is greater or equal to *both* neighbouring points.
     * DO NOT clear the graphics as we also want to view the waveform.
     */
    public void upperEnvelope() {
        /*# YOUR CODE HERE */
    }

    /**
     * [CHALLENGE]
     * Displays the lower envelope with RED lines connecting all the "negative" peaks.
     *    A "negative" peak is defined as a point that is smaller or equal to *both* neighbouring points.
     * DO NOT clear the graphics as we also want to view the waveform.
     */
    public void lowerEnvelope() {
        /*# YOUR CODE HERE */

    }

    /**
     * [CHALLENGE]
     * Saves the current waveform values into a file
     */
    public void doSave(){
        /*# YOUR CODE HERE */

    }

    private int index1;
    /**
     * [CHALLENGE]
     * Lets user select a region of the waveform with the mouse
     * and deletes that section of the waveform.
     */
    public void doMouse(String action, double x, double y){
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/

    /** Constructor:
     * Set up the ten buttons and mouselistener
     */
    public WaveformAnalyser(){
        //core
        UI.addButton("Read Data", this::doRead);
        UI.addButton("Display Waveform", this::doDisplay);
        UI.addButton("Report Distortion", this::doReportDistortion);
        //completion
        UI.addButton("Spread", this::doSpread);
        UI.addButton("Display Distortion", this::doDisplayDistortion);
        UI.addButton("Peaks", this::doHighlightPeaks);
        //challenge
        UI.addButton("Normalise", this::doNormalise);
        UI.addButton("Envelope", this::doEnvelope);
        UI.addButton("Save", this::doSave);
        UI.addButton("Quit", UI::quit);
        UI.setMouseListener(this::doMouse);   // only for challenge

    }

    // Main
    public static void main(String[] arguments){
        new WaveformAnalyser();
    }   

}

       