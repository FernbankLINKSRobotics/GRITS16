package autonomous;

import org.usfirst.frc.team4468.robot.CMap;
import drive.Wedge;

public class Cheval {
	private static boolean reached = false;
	private static boolean wedged = false;
	private static boolean crossed = false;
	private static boolean first = true;
	private static double firstTime;
	public static void cross(double time){
		if(!reached){
			CMap.leftDrivePID.getPIDController().setSetpoint(20);
			CMap.rightDrivePID.getPIDController().setSetpoint(20);
			if(CMap.leftDrivePID.getPosition() >= 19){
				CMap.leftDrivePID.getPIDController().disable();
				CMap.rightDrivePID.getPIDController().disable();
				reached = true;
			}
		} else if(!wedged){
			Wedge.change("down");
			if(CMap.wedgeArmPID.getPosition() >= CMap.wedgeArmPID.getSetpoint() - 1){
				wedged = true;
			}
		} else if(!crossed) {
			CMap.leftDrive.set(1);
			CMap.rightDrive.set(1);
			if(first){
				firstTime = time;
				first = false;
			} else if((time - firstTime) >= 4){
				CMap.leftDrive.set(0);
				CMap.rightDrive.set(0);
			}
		}
	}
}
