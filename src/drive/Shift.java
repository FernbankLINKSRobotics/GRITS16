package drive;

import org.usfirst.frc.team4468.robot.CMap;

public class Shift {
	static boolean beenPressed = false;
	static boolean turnOn = false;
	
	public static void shiftDrive(){
    	if (CMap.leftJoystick.getTrigger()) {
    		if (!beenPressed) { 
    			turnOn = !turnOn; 
    		}
    		beenPressed = true; 
    	}
    	else {
    		beenPressed = false;
    	}
    	
    	if (turnOn) { 
    		CMap.leftGearShift.set(true); 
    		CMap.rightGearShift.set(true);
    	}
    	else { 
    		CMap.leftGearShift.set(false);
    		CMap.rightGearShift.set(false);
    	}
	}
}
