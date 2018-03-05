// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 3 
 * Name:Darrwn Carroll
 * Usercode:carroldarr
 * ID:300301318
 */

import ecs100.*;

/** Program to create simple animated cartoon strips using the
 *  CartoonFigure class.  
 */

public class CartoonStrip{

    /** animate creates two cartoon figures on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the figures.
     */
    public void animate(){
        CartoonFigure g1 = new CartoonFigure("girl1", 100, 100);
        UI.println("In the morning jenny wakes up and has toast and a cup of tea");
        g1.boilWater(2000);
        g1.toast();
        CartoonFigure b1 = new CartoonFigure("guy1", 100, 100);
        UI.println("James doesnt like breakfast, he just reheats lastnights dinner at takes some baking to eat on the way to work");
        g1.reheatFood(10, 500);
        g1.bake(200);
        UI.println("when james and jenny get home in the afternoon, they relax by watching TV and using the computer.");
        g1.watchTV(2,50);
        g1.useComputer(500);
        UI.println("After relaxing they both do some chores in preperation for the next day");
        g1.washLoad(true, "cold");
    	g1.vacuum(50);
    	g1.getPowerBill();
    	g1.payPowerBill();
    	g1.go();
    	
    }

    /** For the completion, the story must be a gamebook story
     *      where the user is asked to make decisions about what the characters will do.
     *   At the end it must print out the users power bill for the story that they chose.
     */
    public void animateCompletion(){
        UI.clearPanes();
        String nameVar = "";
        String sex = UI.askString("are you a boy or girl?");
        
        if ((!sex.equals("boy")) && (!sex.equals("girl")))
        {
            UI.println("please insert boy or girl");
            return;
        }
    	if (sex.equals("boy"))
    	{
    	   nameVar = "guy1";
    	   }
    	else if (sex.equals("girl"))
    	{
    	nameVar = "girl1";
    	}
        CartoonFigure d1 = new CartoonFigure(nameVar, 100, 100);
        String realName = UI.askString("what is you name?");
        String meal = UI.askString("Do you prefer leftovers or toast?");
        
        if (meal.contains("leftovers")){
        d1.reheatFood(10, 500);
        UI.println(realName + " likes to eat leftovers.");
        }
        else if (meal.contains("toast")){
         d1.toast();
         UI.println(realName + " likes to eat toast.");
        }
        else {
        UI.println("Please insert leftovers or toast prefrence..");
        return;
        }
        
        String activity = UI.askString("Do you prefer to watch tv or play on the computer?");
        if (activity.contains("tv")){
        d1.watchTV(2,50);
        UI.println(realName + " likes to watch TV.");
        }
        else if (activity.contains("computer")){
        d1.useComputer(500);
        UI.println(realName + " likes to us the computer.");
        }
        else {
        UI.println("Please insert tv or computer prefrence..");
        return;
        }
        
        String chor = UI.askString("Do you prefer to Vacumme or do the washing?");
        if (chor.contains("vacumme")){
        d1.vacuum(50);
        UI.println(realName + " is doing the vacumming.");
        }
        else if (chor.contains("washing")){
        d1.washLoad(true, "warm");
        UI.println(realName + " is doing the washing.");
        }
        else {
        UI.println("Please insert vacumme or washing prefrence..");
        return;
        }
        d1.getPowerBill();
    }
	
    public void animateChallange(){
        UI.clearPanes();
        String nameVar = "";
        String sex = UI.askString("are you a boy or girl unsure?");
        
        if ((!sex.equals("boy")) && (!sex.equals("girl")) && (!sex.equals("unsure")))
        {
            UI.println("please insert 'boy', 'girl' or 'unsure'..");
            return;
        }
    	if (sex.equals("boy"))
    	{
    	   nameVar = "boy1";
    	   }
    	else if (sex.equals("girl"))
    	{
    	nameVar = "lady1";
    	}
    	else if (sex.equals("unsure"))
    	{
    	nameVar = "unsure1";   
    	}
        CartoonFigure d1 = new CartoonFigure(nameVar, 100, 100);
        String realName = UI.askString("what is you name?");
        
        String xbox = UI.askString("Do you wish to play xbox?");
        if (xbox.contains("yes"))
        {
       	 	d1.xbox();
        	UI.println(realName + "likes to play xbox");
        }
        
        String toothBrush = UI.askString("Do you wish to brush your teeth?");
         if (toothBrush.contains("yes"))
        {
       	 	d1.xbox();
        	UI.println(realName + "likes to use tooth brush");
        }
        
        String meal = UI.askString("Do you prefer leftovers or toast?");
        if (meal.contains("leftovers")){
        	d1.reheatFood(10, 500);
        	UI.println(realName + " likes to eat leftovers.");
        }
        else if (meal.contains("toast")){
         d1.toast();
         UI.println(realName + " likes to eat toast.");
        }
        else {
        UI.println("Please insert leftovers or toast prefrence..");
        return;
        }
        
        String activity = UI.askString("Do you prefer to watch tv or play on the computer?");
        if (activity.contains("tv")){
        d1.watchTV(2,50);
        UI.println(realName + " likes to watch TV.");
        }
        else if (activity.contains("computer")){
        d1.useComputer(500);
        UI.println(realName + " likes to us the computer.");
        }
        else {
        UI.println("Please insert tv or computer prefrence..");
        return;
        }
        
        String chor = UI.askString("Do you prefer to Vacumme or do the washing?");
        if (chor.contains("vacumme")){
        d1.vacuum(50);
        UI.println(realName + " is doing the vacumming.");
        }
        else if (chor.contains("washing")){
        d1.washLoad(true, "warm");
        UI.println(realName + " is doing the washing.");
        }
        else {
        UI.println("Please insert vacumme or washing prefrence..");
        return;
        }
        d1.getPowerBill();
    }
    /** ---------- The code below is already written for you ---------- **/
        /** Constructor: set up user interface */
    public CartoonStrip(){
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("Animate", this::animate );
        UI.addButton("Animate Completion", this::animateCompletion );
        UI.addButton("Animate Challange", this:: animateChallange);
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0);       // Expand the graphics area
    }


}

