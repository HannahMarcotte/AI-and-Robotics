import lejos.nxt.*;
import lejos.util.Delay;

public class Mission6 {
	public static void pause() {
        Delay.msDelay(500);
    }
    public static void main(String[] args) {

        Motor.A.setSpeed(400);
        Motor.B.setSpeed(400);
        Motor.C.setSpeed(200);
        Button.waitForPress();
        
     // Drive to structure
        Motor.A.rotate(2750, true);
        Motor.B.rotate(2750);
        pause();
        
        // turn
        Motor.A.rotate(-490, true);
        Motor.B.rotate(490);
        pause();
        
        // go straight to mission 6
        Motor.A.rotate(4400, true);
        Motor.B.rotate(4400);
        pause();
        
     // turn
        Motor.A.rotate(490, true);
        Motor.B.rotate(-490);
        pause();
        
        // bring arm up
        Motor.C.rotate(-70);
        pause();
        
        // turn
        Motor.A.rotate(540, true);
        Motor.B.rotate(-540);
        pause();
        
        // go back home
        Motor.A.rotate(4400, true);
        Motor.B.rotate(4400);
        pause();
        
        Motor.A.rotate(490, true);
        Motor.B.rotate(-490);
        pause();
        
        Motor.A.rotate(2750, true);
        Motor.B.rotate(2750);
        pause();
        

        

        Button.waitForPress();
    }
}
