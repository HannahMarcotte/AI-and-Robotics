import lejos.nxt.*;
import lejos.util.Delay;

public class Mission4 {

    public static void pause() {
        Delay.msDelay(500);
    }

    public static void main(String[] args) {

        // Speeds
        Motor.A.setSpeed(300);
        Motor.B.setSpeed(300);
        Motor.C.setSpeed(180);

        Button.waitForPress();

        // =========================
        // STEP 1: DRIVE ACROSS FIELD
        // =========================
        Motor.A.rotate(3250, true);
        Motor.B.rotate(3250);
        pause();

        // =========================
        // STEP 2: TURN TOWARD MINE
        // (adjust direction if needed)
        // =========================
        Motor.A.rotate(-415, true);
        Motor.B.rotate(415);
        pause();

        // =========================
        // STEP 3: APPROACH ARTIFACT
        // =========================
        Motor.A.setSpeed(100);
        Motor.B.setSpeed(100);

        Motor.A.rotate(375,true);
        Motor.B.rotate(375);
        pause();

        // =========================
        // STEP 4: lift HOOK
        // =========================
        Motor.C.rotate(-10);
        pause();

        // =========================
        // STEP 5: PULL ARTIFACT OUT
        // =========================
        Motor.A.rotate(-250, true);
        Motor.B.rotate(-250);
        pause();

        // Lower artifact
        Motor.C.rotate(1);
        pause();

        // =========================
        // STEP 6: RETURN HOME
        // =========================
        Motor.A.setSpeed(300);
        Motor.B.setSpeed(300);

        // Back away
        Motor.A.rotate(-200, true);
        Motor.B.rotate(-200);
        pause();

        // Turn back toward home
        Motor.A.rotate(-600, true);
        Motor.B.rotate(600);
        pause();

        // Drive back across field
        Motor.A.rotate(3250, true);
        Motor.B.rotate(3250);
        pause();

        Sound.beepSequence();
        Button.waitForPress();
    }
}