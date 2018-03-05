// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

import ecs100.*;

/** Program MazeMouse for COMP102  
 * Author:  pondy  <P>
 * Original Date: Jan 26, 1998  <P>
 * Revision: Feb 2006, Feb 2011, Feb 2014<P>
 * Description: Simulates a robot mouse in a maze.  <P>
 * The mouse can move forward (one step), turn left, or turn right  <P>
 * It can sense the cell in front of it and the cell on each side  <P>
 * The user can specify the behaviour of the mouse by listing sequences
 * of actions to respond to each of five events:  <P>
 * Space-ahead, space-to-left, space-to-right space-both-sides dead-end  <P>
 * The actions are specified by a string of M, L, R, and ?  <BR>
 * M is for "move forward"  <BR>
 * L is for "turn left"     <BR>
 * R is for "turn right"    <BR>
 * ? is for do a random choice of one of the other three actions  <BR>
 */

public class MazeMouse {

    public static void main(String[] args){
        new MazeMouse();
    }

    private Maze maze = new Maze(13, 13);
    private Mouse mouse = new Mouse(maze);

    public MazeMouse(){
        UI.initialise();
        UI.setMouseListener(this::doMouse );
        UI.addButton("Restart", mouse::reset);            
        UI.addButton("Step", mouse::step);
        UI.addButton("Run", mouse::go);
        UI.addButton("Quit", UI::quit);

        //The text fields and sliders
        UI.addTextField("Space ahead", mouse::setOnSpaceAhead );
        UI.addTextField("Space only on left", mouse::setOnSpaceToLeft );   
        UI.addTextField("Space only on right",mouse::setOnSpaceToRight );
        UI.addTextField("Space on both sides",mouse::setOnSpaceBothSides );
        UI.addTextField("At dead end", mouse::setOnDeadEnd );           
        UI.addSlider("Speed", 1, 10, 8, mouse::setSpeed);
        UI.addSlider("Run for", 10, 200, 100, mouse::setSteps);
        UI.setWindowSize(750,650);
        UI.setDivider(0);
        maze.draw();
        mouse.reset(); 
    }

    public void doMouse(String action, double x, double y) {
        if (action.equals("clicked")){maze.changeCell((int)x,(int)y);}
    }

}
