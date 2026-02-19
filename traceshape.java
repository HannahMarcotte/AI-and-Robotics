import lejos.nxt.*;
import lejos.robotics.navigation.*;
public class traceshape {

	/**
	 * @param args
	 */
	
	DifferentialPilot pilot;
	// robot travels
	public void go(){
		pilot.travel(93.5);
	}
	// turn 90 degrees
	public void turn(){
		pilot.travel(100, true);
		pilot.rotate(90.0);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCD.drawString("square", 0, 0);
		Button.waitForPress();
		LCD.clear();
		
		traceshape bot = new traceshape();
		bot.pilot = new DifferentialPilot(3.1, 17.25, Motor.A, Motor.C);
		// set speed of the robot
		bot.pilot.setTravelSpeed(25);
		
		// does the actions 4 times
		for(int i = 0; i < 4; i++){
			bot.go();
			bot.turn();
		}
		
		Button.waitForPress();
		
	}

}
