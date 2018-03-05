// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 2  COMP102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various symbols: flags, signs, and car logos
 *
 * The correct dimensions of the official flags varies from country to country,
 * The exact colours of the flags will also be difficult to match;
 * It is fine to use the standard colours: red, green, blue, orange, etc
 * You can find lots of flag details (including the correct dimensions and colours)
 * from   http://www.crwflags.com/fotw/flags/    
 */
public class SymbolDrawer{

    public static final double top = 100;
    public static final double left = 50;

    /** The flag of France has three vertical stripes;
     *  The left is blue, the right is red and the middle is white.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  CORE
     */
    public void franceFlag(){
        /*# YOUR CODE HERE */

    }

    /** The hospital sign consists of a blue square with a big white centred H
     *  The H consists of 3 rectangles (width is the size divided by 7.5
     *  A square means that the hight and the width are of equal size
     *  CORE
     */
    public void hospitalSign() {
        /*# YOUR CODE HERE */

    } 

    /**
     *  The flag of Laos has three horizontal stripes with a white circle in the centre;
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  The top and bottom stripes are red, and they are each 1/4 of the height of the flag.
     *  The middle stripe is blue and it is 1/2 of the height of the flag.
     *  The diameter of white circle is 4/5 the height of blue strip, 
     *       eg 2/5 of the total height.
     *  CORE
     */
    public void laosFlag() {
        /*# YOUR CODE HERE */

    }

    /**
     *  The flag of the United Arab Emirates is divided into four rectangular parts.
     *  The first red rectangle is the vertical band nearest to the mast, its length being
     *  equivalent to the height of the flag, while its width is one quarter of the length of
     *  the entire flag.
     *  The other three parts are three horizontal stripes of equal size.
     *  The top most is green, the middle is white and the lower is black.
     *  The flag is 1/2 as high as it is wide (ratio 1:2).
     *  COMPLETION
     */
    public void uaeFlag() {
        /*# YOUR CODE HERE */

    }

    /** The flag of Greenland is a rectangle whose top half is white
     *  and bottom half is red. There is a circle in the middle (off-set to left) 
     *  which is also half white/red but on the opposite sides.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  COMPLETION
     */
    public void greenlandFlag() {
        /*# YOUR CODE HERE */

    }

    /** Mitsubishi
     * 
     *  CHALLENGE
     */
    public void mitsubishiLogo() {
        /*# YOUR CODE HERE */

    }

    /** The Koru flag belongs to the long list of new flags designs
     *  It has been designed by Sven Baker from Wellington
     *  The flag is 1/2 as high as it is wide (ratio 1:2).
     *  CHALLENGE
     */
    public void koruFlag() {
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor, sets up the user interface */
    public SymbolDrawer(){
        UI.initialise();

        // CORE
        UI.addButton("Core: Flag of France", this::franceFlag);
        UI.addButton("Core: Hospital Sign", this::hospitalSign);
        UI.addButton("Core: Flag of Laos", this::laosFlag);

        // COMPLETION
        UI.addButton("Completion: Flag of UAE", this::uaeFlag);
        UI.addButton("Completion: Flag of Greenland", this::greenlandFlag);

        // CHALLENGE
        UI.addButton("Challenge: Mitsubishi", this::mitsubishiLogo);
        UI.addButton("Challenge: Koru Flag", this::koruFlag);
        UI.addButton("Quit", UI::quit);
    }


}
