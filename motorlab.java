import lejos.nxt.*;// needed for all programs
/**
 * two morots run forward then backward as button is pressed.
 * @author marco
 *
 */


public class motorlab {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Motor.A.forward();
		Motor.C.forward();
		LCD.drawString("FORWARD", 0, 0);
		Button.waitForPress();
		Motor.A.backward();
		Motor.C.backward();
		LCD.drawString("BACKWARD", 0, 1);
		Button.waitForPress();
		Motor.A.stop();
		Motor.C.stop();

	}

}
