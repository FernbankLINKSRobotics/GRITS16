package drive;

import org.usfirst.frc.team4468.robot.CMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DriverStation;

public class Shift {
	private static boolean beenPressed = false;
	private static boolean solenoidOn = false;
	public static void shift(){
		
		if(CMap.leftJoystick.getTrigger()){
			if(!beenPressed){
				solenoidOn = !solenoidOn;
			}
			
			beenPressed = true;
		} else {
			beenPressed = false;
		}
		
		if(solenoidOn){
			CMap.gearShift.set(DoubleSolenoid.Value.kForward);
		} else {
			CMap.gearShift.set(DoubleSolenoid.Value.kReverse);
		}
		 
	}
	
}
