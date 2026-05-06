import lejos.nxt.*;
import lejos.util.Delay;

public class Mission5 {
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
        
        // go straight to mission 5
        Motor.A.rotate(4150, true);
        Motor.B.rotate(4150);
        pause();
        
        // turn to the red push
        Motor.A.rotate(450, true);
        Motor.B.rotate(-450);
        pause();

        // backup
        Motor.A.rotate(-215, true);
        Motor.B.rotate(-215);
        pause();
        
        // turn back to go home
        Motor.A.rotate(625, true);
        Motor.B.rotate(-625);
        pause();
       
        // drive straight
        Motor.A.rotate(4150, true);
        Motor.B.rotate(4150);
        pause();
        
        // turn toward white home circle
        Motor.A.rotate(490, true);
        Motor.B.rotate(-490);
        pause();
        
        Motor.A.rotate(2750, true);
        Motor.B.rotate(2750);
        pause();

       
        Button.waitForPress();
    }
}