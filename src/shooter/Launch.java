package shooter;
import org.usfirst.frc.team4468.robot.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.*;


public class Launch {
	private static boolean beenPressed = false;
	private static boolean wheelsAreMoving = false;
	private static boolean launched = false;
	private static int timeSinceStart;
	
	public static void shootBoulder(){
		speedUpWheels(); //Method will also do the opposite
		if(wheelsAreMoving){
			//Code to launch boulder
		}
		//Code to launch boulder will go
		//here. I think we are rolling
		//with a pneumatic punch but
		//I will check with Adam before
		//continuing
	}
	
	public static void speedUpWheels(){
		if(!DriverStation.getInstance().isAutonomous()){
			if(CMap.armJoystick.getTrigger()){
				if(!beenPressed){
					wheelsAreMoving = !wheelsAreMoving;
					beenPressed = !beenPressed;
				}
				beenPressed = true;
			} else {
				beenPressed = false;
			}
		} else if(DriverStation.getInstance().isAutonomous()){
			wheelsAreMoving = !wheelsAreMoving;
		}
			
		if(wheelsAreMoving){
			CMap.shooterLeftTalon.set(1.0);
			CMap.shooterRightTalon.set(1.0);
		} else if(!wheelsAreMoving){
			CMap.shooterLeftTalon.set(0);
			CMap.shooterRightTalon.set(0);
		}
	}

	public static boolean autoLaunch(){
		CMap.shooterLeftTalon.set(1.0);
		CMap.shooterRightTalon.set(1.0);
		
		timeSinceStart += 1;
		
		if(timeSinceStart >= 125){
			//Get that boulder out of here!
		} else if(timeSinceStart >= 250){ 
			/*
			 * This means that approximately 5 seconds
			 * have passed since the beginning of the
			 * launch sequence.
			 * 
			 * The boulder has probably fired at this
			 * point.
			 */
			
			CMap.shooterLeftTalon.set(0);
			CMap.shooterRightTalon.set(0);
			launched = true;
		}
		return launched;
	}
}
