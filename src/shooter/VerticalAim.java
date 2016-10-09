package shooter;

import org.usfirst.frc.team4468.robot.CMap;

public class VerticalAim {
	public static void aim(){
		
		if(CMap.auxJoystick.getY() > 0.2){
			CMap.shooterPID.setSetpoint(CMap.shooterPID.getSetpoint() + 0.3);
		} else if(CMap.auxJoystick.getY() < -0.2){
			CMap.shooterPID.setSetpoint(CMap.shooterPID.getSetpoint() - 0.08);
		} else if(CMap.auxJoystick.getRawButton(6)){
			CMap.shooterPID.setSetpoint(1);
		} else {
			CMap.shooterPID.setSetpoint(CMap.shooterPID.getSetpoint());
		}
		
	}
}
