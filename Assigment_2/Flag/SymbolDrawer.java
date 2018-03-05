import ecs100.*;
import java.awt.Color;

public class SymbolDrawer{
    public static final double top = 100;
    public static final double left = 100;

    public SymbolDrawer(){
        UI.initialise();
        UI.clearPanes();
        UI.addButton("clear", UI::clearGraphics);
        UI.addButton("France", this::FranceFlag);
        UI.addButton("Hospital", this::HospitalFlag);
        UI.addButton("Laos", this::LaosFlag);
        UI.addButton("Arab Emirates", this::ArabFlag);
        UI.addButton("Greenland", this::GreenLandFlag);
        UI.addButton("Quit", UI::quit);

    }

    public void FranceFlag(){
        Double width = UI.askDouble("please enter width");
        Double height = width*2/3.0;
        //Double diamater = height* 3/5.0;

        UI.clearGraphics();
        //UI.setColor(Color.black);
        //UI.drawRect(left,top,width,height); //LTWH
        UI.setColor(Color.blue);
        UI.fillRect(left,top,left+(width*1/3), height);
        UI.setColor(Color.white);
        UI.fillRect(left+width*1/3,top, left + width*2/3, height);
        UI.setColor(Color.red);
        UI.fillRect(left+width*2/3,top, left + width, height);
        UI.setColor(Color.white);
        UI.fillRect(left+width, top, left+width, height);
        //UI.fillOval(left + (width/2.0) - (diamater/2.0), top + (height/2.0) - (diamater/2.0), diamater, diamater);

    }

    public void HospitalFlag(){
        Double size = UI.askDouble("please enter Size of the flag");
        Double width = size;
        Double height = size;

        UI.clearGraphics();
        UI.setColor(Color.blue);
        UI.fillRect(left, top, width, height);
        UI.setColor(Color.white);
        UI.fillRect(left+size/4.0, top+size/5.0, size/7.50, size*3/5);
        UI.fillRect(left+size*3/4-size/7.5, top+size/5.0, size/7.50, size*3/5);
        UI.fillRect(left+size/4.0,top+size/2-size/7.5/2,size/2,size/7.50);

        //UI.setLineWidth(width*.2);
        //UI.drawLine(left, top, left + width*10, 100);
    }

    public void LaosFlag(){
        double width = UI.askDouble("Please enter you preffered size");
        double height = width*2/3.0;
        double diamater = height*4/10.0; 

        UI.clearGraphics();
        UI.setColor(Color.red.darker());
        UI.fillRect(left, top, width,(height*1/4.0));
        UI.setColor(Color.blue);
        UI.fillRect(left, top + height*(1/4.0), width, (height*2/4.0));
        UI.setColor(Color.red.darker());
        UI.fillRect(left, top+height*3/4.0, width, height*(1/4.0));
        UI.setColor(Color.white);
        UI.fillOval(left + (width/2.0) - (diamater/2.0), top + (height/2.0) - (diamater/2.0), diamater, diamater);

        //UI.setColor(Color.black);
        //UI.drawRect(left,top,width,height); //LTWH

        //UI.setColor(Color.red);
        //UI.fillOval(left + (width/2.0) - (diamater/2.0), top + (height/2.0) - (diamater/2.0), diamater, diamater);

    }
    public void ArabFlag(){
    double width = UI.askDouble("How big would you like the flag?");
    double height = width * 1.8/3.0;
    
    UI.clearGraphics();
    UI.setColor(Color.red);
    UI.fillRect(left, top, width*1/5.0, height);
    UI.setColor(Color.green);
    UI.fillRect(left + width*1/5.0, top, width*4/5.0, height*1/3.0);
    UI.setColor(Color.black);
    UI.fillRect(left + width*1/5.0, top + height*2/3.0,width*4/5.0,height*1/3.0);
    }
    public void GreenLandFlag(){
    double width = UI.askDouble("How big would you like it?");
    double height = width*2/3.00;
    
    UI.clearGraphics();
    UI.setColor(Color.black);
    UI.drawRect(left, top, width, height);
    UI.setColor(Color.red);
    UI.fillRect(left, top + (height/2.0), width, height/2.0);
    UI.fillArc(left + width/10.0, top + height*.2, width*3/8.0, height*6/10.0, 0, 180);
    UI.setColor(Color.white);
    UI.fillArc(left + width/10.0,top + height*.20, width*3/8.0, height*6/10, 180, 180);
}
}