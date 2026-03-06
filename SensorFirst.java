import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;


public class SensorFirst {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TouchSensor ts = new TouchSensor(SensorPort.S1);
		DifferentialPilot pilot = new DifferentialPilot(3.0, 15.0, Motor.A, Motor.C);

        // Rotate the robot 90 degrees to the right
		Button.waitForPress();
		while(!Button.ESCAPE.isPressed()){
			pilot.forward();
			
			if(ts.isPressed()){
				pilot.backward();
				Thread.sleep(2000);
				pilot.rotate(90.0);
			}
		}

	}

}
