import lejos.nxt.*;


import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.NavPathController;

public class Coordinatemove {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DifferentialPilot robot = new 
				DifferentialPilot(3.1, 17.25, Motor.A, Motor.C);
		NavPathController nav = new NavPathController(robot);
		robot.setTravelSpeed(25);
		
		Button.waitForPress();
		LCD.drawString("(20,20)", 0, 0);
		LCD.drawString("Press ENTER key", 1, 1);
		Button.ENTER.waitForPressAndRelease();
		nav.goTo(20,20);	
		LCD.clear();
		
		
		
		LCD.drawString("(0,0)", 0, 3);
		LCD.drawString("Press Enter key", 1, 1);
		Button.ENTER.waitForPressAndRelease();
		nav.goTo(0,0);
		LCD.clear();
		
		LCD.drawString("(-20,20)", 0, 4);
		LCD.drawString("Press Enter key", 1, 1);
		Button.ENTER.waitForPressAndRelease();
		nav.goTo(-20,20);
		
		
		
		LCD.drawString("(0,0)", 0, 6);
		LCD.drawString("Press Enter key", 1, 1);
		Button.ENTER.waitForPressAndRelease();
		nav.goTo(0,0);
		
		
		
		Button.waitForPress();
		
	}
}
