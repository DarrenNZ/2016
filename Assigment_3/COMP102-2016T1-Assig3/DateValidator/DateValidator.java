// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 3
 * Name: Darren Carroll
 * Usercode:
 * ID:300301318
 */

import ecs100.*;
import java.awt.Color;

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */

public class DateValidator {

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Core, you may assume that
     * - All months have 31 days, numbered 1 to 31
     * - The months run from 1 to 12
     * - Years start from 1 
     */
    public void validateDateCore(){
        int inputDay = UI.askInt("What is the day of the month");
        if (inputDay < 1 | inputDay > 31){
        UI.println("The day selected is invalid, please try again.");
        return;
    }
        
        int inputMonth = UI.askInt("What is the Month of the year");
        if (inputMonth < 1 | inputMonth > 12){
        UI.println("The Month selected is invalid, please try again.");
        return;
    }

        int inputYear = UI.askInt("What is the Year");
        if (inputYear < 0 | inputYear > 2016){
    	UI.println("The Year selected is invalid, please try again.");
    	return;
    }
    UI.println("Thankyou your date the "+ inputDay+"/"+inputMonth+"/"+inputYear +" is valid");  
    
        
        

    }

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Completion, you should also check that
     * - Months have the correct number of days
     * - On leap years February should have 29 days.
     *    A year is a leap year if:
     *       - The year can be evenly divided by 4 but not 100
     *       - The year can be evenly divided by 400 
     */
    public void validateDateCompletion(){
          int numOfDayinMonth = 28;
          int inputMonth = UI.askInt("What is the Month of the year");
       	  boolean leap = false;
        if (inputMonth < 1 | inputMonth > 12){
        UI.println("The Month selected is invalid, please try again.");
        return;
    	}
        
    	   int inputYear = UI.askInt("What is the Year");
        if (inputYear < 0 | inputYear > 2016){
    	UI.println("The Year selected is invalid, please try again.");
    	return;
    	}
    	
    	//if ((inputYear % 4 == 0) && (inputYear % 100 != 0) && (inputYear % 400 == 0))
    	if ((inputYear % 4 == 0) && (inputYear % 100 != 0) || (inputYear % 400 == 0))
    	{
    	   leap = true;
    	}
    	
        if (inputMonth == 1)
        {
        numOfDayinMonth = 31; 
    	}
    	else if (inputMonth == 2 & leap == true)
    	{
    		  numOfDayinMonth = 29;
    	}
    	else if (inputMonth == 3)
    	{
    	numOfDayinMonth = 31;
    	}
    	else if (inputMonth == 4)
    	{
    	numOfDayinMonth = 30;
    	}
    	else if (inputMonth == 5)
    	{
    	numOfDayinMonth = 31;
    	}
    	else if (inputMonth == 6)
    	{
    	numOfDayinMonth = 30;
    	}
    	else if (inputMonth == 7)
    	{
    	numOfDayinMonth = 31;
    	}
    	else if (inputMonth == 8)
    	{
    	numOfDayinMonth = 313;
    	}
    	else if (inputMonth == 9)
    	{
    	numOfDayinMonth = 30;
    	}
    	else if (inputMonth == 10)
    	{
    	numOfDayinMonth = 31;
    	}
    	else if (inputMonth == 11)
    	{
    	numOfDayinMonth = 30;
    	}
    	else if (inputMonth == 12)
    	{
    	numOfDayinMonth = 31;
    	}
    

        int inputDay = UI.askInt("What is the day of the month");
        if (inputDay < 1 | inputDay > numOfDayinMonth){
        UI.println("The day selected is not valid for your month, please try again.");
        return;
    }
        

    UI.println("Thankyou your date the "+ inputDay+"/"+inputMonth+"/"+inputYear +" is valid");  
    if (leap == true){UI.println("leap true");}

    }

    /**
     * For the challenge, your program should be extended to deal with the transition from the Julian to Gregorian calendar. 
     * The program should look at the date, determine whether this should be a Julian or Gregorian date, and test it appropriately. 
     * You will need to find the rules of the Julian calendar yourselves. 
     * 
     */
    public void validateDateChallenge(){
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public DateValidator(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Validate Date Core", this::validateDateCore );
        UI.addButton("Validate Date Completion", this::validateDateCompletion );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }


}

