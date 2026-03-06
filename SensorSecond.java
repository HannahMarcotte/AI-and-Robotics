import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;


public class SensorSecond {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button.waitForPress();
		UltrasonicSensor ultraSonic = new UltrasonicSensor(SensorPort.S2);
		DifferentialPilot pilot = new DifferentialPilot(3.0, 15.0, Motor.A, Motor.C);
		while(!Button.ESCAPE.isPressed()){
			int distance = ultraSonic.getDistance();
			while(distance > 10){
				pilot.forward();
				distance = ultraSonic.getDistance();
			}
			if(distance <= 10){
				while(distance <= 20){
					pilot.backward();
					distance = ultraSonic.getDistance();
				}
				pilot.rotate(90);
			}
		}

	}

}
