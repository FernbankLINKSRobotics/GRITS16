package autonomous;
import org.usfirst.frc.team4468.robot.*;
import vision.*;

public class LowBar {
	/*
	 * The code first checks if it has crossed.
	 * If it hasn't, it will cross the defense and
	 * set initialCrossComplete to true/
	 * 
	 * Next, it lines itself up by using encoders. Because,
	 * the robot can't fly over the defense. Vision won't be needed
	 * for alignment. This also opens the possibility for a 2
	 * boulder autonomous resulting in a 30 point autonomous by the
	 * robot.
	 * 
	 * As of right now, the code is set up for a one boulder autonomous.
	 */
	public static void cross(){
		if(!CMap.initialCrossComplete){
			CMap.leftPID.setSetpoint(156);
			CMap.rightPID.setSetpoint(156);
			if(CMap.leftPID.getPosition() > 154){
				CMap.initialCrossComplete = true;
				System.out.println("I've crossed the Low Bar!");
			}
			//Lines Up for a Shot
		} else if (!CMap.linedUp){
			CMap.leftPID.setSetpoint(177); //Needs to be tweaked
			if(CMap.leftPID.getPosition() >= 175){
				CMap.linedUp = true;
				System.out.println("I'm lined up! About to fire!");
			}
			//Launches the boulder
		} else if (!CMap.launched) {
			CMap.shooterLeftTalon.set(1.0);
			CMap.shooterRightTalon.set(1.0);
			CMap.timeSinceLaunch += 1;
			if(CMap.timeSinceLaunch >= 250){ //5 seconds to launch boulder
				CMap.launched = true;
				CMap.shooterLeftTalon.set(0);
				CMap.shooterRightTalon.set(0);
			}
		} else if (!CMap.backInNeutral) {
			CMap.leftPID.setSetpoint(156);
			if(CMap.leftPID.getPosition() <= 154){
				CMap.leftPID.setSetpoint(0);
				CMap.rightPID.setSetpoint(0);
			}
		}
		
		
		
	}
}
