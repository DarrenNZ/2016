import ecs100.*;

public class PowerCalculator{
    
    public static final double priceKWH = 0.1;
    //public static final double incandescentLifeSpan = 1400;
    //public static final double ledLifeSpan = 1560;
    public static final double incandescentPrice = 20;
    Double newBulb = 0.0;
    Double oldBulb = 0.0;
    Double numOfBulb = 0.0;
    Double hoursPerDay = 0.0;
    Double daysPerWeek = 0.0;
    Double weekPerYear = 0.0;
    Double ledBulbCost = 0.0;
    
    public PowerCalculator(){
        UI.initialise();
        UI.addButton("Power Calculator", this::PowerCalculator);
        UI.addButton("Calculate Cost Saver", this::calculateCostSaverCompletion);
        UI.addButton("quit", UI::quit);
    }

    public void PowerCalculator(){
        newBulb = UI.askDouble("What wattage is the newer bulb");//7
        oldBulb = UI.askDouble("What wattage is the older bulb");//60
        numOfBulb = UI.askDouble("How many bulbs are you relapcing");//4
        Double result1 = ((oldBulb - newBulb) * numOfBulb)/ 1000.0;
        UI.println("you are now saving "+ result1 + " kilowatts every hour.");
        
        hoursPerDay = UI.askDouble("How many hours each day is the light on?");//5
        daysPerWeek = UI.askDouble("How many days per week is the light on?");//7
        weekPerYear = UI.askDouble("How many weeks per year is the light on?");//52
        Double result2 = ((0.212* hoursPerDay * daysPerWeek)* weekPerYear);
        UI.println("you will save " + result2 + " kilowatts per year.");
        
        Double result3 = (result2* 0.2034);
        UI.println("your will save $"+ result3+" per year");
        
        ledBulbCost = UI.askDouble("How much does each LED bulb cost?");//17.66
        Double result4 = ((numOfBulb * ledBulbCost)/ result3);
        UI.println("Your investment will pay itself off in "+ result4 +" years");
    }
    
    public void calculateCostSaverCompletion(){
        this.PowerCalculator();
        Double yearOver = UI.askDouble("years to calculate over?");
    	Double hoursOver = yearOver*8760;
    	
    	double incandescenthoursYear = (hoursPerDay * daysPerWeek)* weekPerYear;
    	double incandescentWattsYear = incandescenthoursYear*oldBulb;
    	double incandescenttotalwatts = incandescentWattsYear* yearOver;
    	double incandescentCost = incandescenttotalwatts* priceKWH;
    	double incandescentTotalCost = incandescentCost + (incandescentPrice* numOfBulb);
    	UI.println("Cost of using and replacing incandescent bulbs over "+ yearOver+" years is $"+ incandescentTotalCost);
    	
    	//UI.println("cost of upgrading and replacing led bulbs");
    	double ledPurchaseCost = ledBulbCost* numOfBulb;
    	double ledHoursPerYear = incandescenthoursYear;
    	double ledWatts = 8;
    	double ledTotalWatts = ledHoursPerYear*ledWatts;
    	double ledTotalCost = ledPurchaseCost + (ledTotalWatts* yearOver);
    	UI.println("cost of purchasing led bulbs and using them over a "+ yearOver +" period will cost $"+ ledTotalCost);
    	
    	double totalSave = incandescentTotalCost - ledTotalCost;
    	
    	UI.println("you will save "+ totalSave +" by using led bulbs over "+ yearOver+" years");
    }
}