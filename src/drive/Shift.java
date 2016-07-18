package drive;

import org.usfirst.frc.team4468.robot.CMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DriverStation;

public class Shift {
	static boolean beenPressed = false;
	static boolean turnOn = false;
	static boolean justShifted = false;
	
	public static void shiftDrive(){
    	if (CMap.leftJoystick.getTrigger()) {
    		if (!beenPressed) { 
    			turnOn = !turnOn; 
    			justShifted = !justShifted;
    		}
    		beenPressed = true; 
    	}
    	else {
    		beenPressed = false;
    	}
    	
    	if (turnOn) { 
    		CMap.leftGearShift.set(true); 
    		CMap.rightGearShift.set(true);
    		if(justShifted){
    			System.out.println("Shifted to high gear at " + DriverStation.getInstance().getMatchTime() + ".");
    			justShifted = false;
    		}
    	}
    	else { 
    		CMap.leftGearShift.set(false);
    		CMap.rightGearShift.set(false);
    		if(justShifted){
    			System.out.println("Shifted to low gear at " + DriverStation.getInstance().getMatchTime() + ".");
    			justShifted = false;
    		}
    	}
	}
}
