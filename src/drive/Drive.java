package drive;
import org.usfirst.frc.team4468.robot.CMap;

import edu.wpi.first.wpilibj.*;
public class Drive {

	public static void drive(){
		/*
		if(Math.abs(CMap.leftJoystick.getY()) > 0.1){
			CMap.leftDriveTalon.set(CMap.leftJoystick.getY());
		} else {
			CMap.leftDriveTalon.set(0);
		}
		
		if(Math.abs(CMap.rightJoystick.getY()) > 0.1){
			CMap.rightDriveTalon.set(CMap.rightJoystick.getY());
		} else {
			CMap.rightDriveTalon.set(0);
		} **/
		
		CMap.driveTrain.tankDrive(CMap.leftJoystick.getY(), CMap.rightJoystick.getY());
	}
}
