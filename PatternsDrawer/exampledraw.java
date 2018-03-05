import ecs100.*;
public class exampledraw{
    public void drawStuff(){
    int y = 0;
    boolean last = false;
    //boolean prev = false;
    while ( y < 400 ){
            int x =0;
            while ( x <= 400 ){
                if ( ! last ){
                    UI. fillRect (x, y, 50, 50);
                    last = true;
                }
                else {
                    UI.drawRect(x, y, 50, 50);
                        //if (prev){
                         //   last = ! last ;
                       // }
                       // prev = !prev;
                        last = false;
                    }
                    x = x + 50;
                }
                y = y + 50;
            }
    }
}