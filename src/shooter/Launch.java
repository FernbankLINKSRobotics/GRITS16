package shooter;
import org.usfirst.frc.team4468.robot.*;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.*;


public class Launch {
	private static boolean wheelsSpinning = false; //Are the wheels spinning?
	private boolean fired; //Has the boulder been fired?
	private static boolean shootingBeenPressed = false; //Has the shooting button been pressed
	private static boolean abortBeenPressed = false;
	public static void shootBoulder(){
		
		 if(CMap.auxJoystick.getTrigger()){
		 	if(!shootingBeenPressed){
		 		if(!wheelsSpinning){
		 			//If the wheels aren't spinning
		 			//First shooting motion
		 			spinWheels(true);
		 			wheelsSpinning = true;
		 		} else if(wheelsSpinning){
		 			//Pneumatic Punch
		 			Timer.delay(2);
		 			spinWheels(false);
	 			}
		 	}
		 	
		 	shootingBeenPressed = true;
		 } else if(CMap.auxJoystick.getRawButton(2) && !abortBeenPressed){
		 	spinWheels(false);
		 	abortBeenPressed = true;
		 } else {
		 	abortBeenPressed = false;
		 	shootingBeenPressed = false;
		 }
		 
	}
	
	public static void spinWheels(boolean state){
		if(state){
			CMap.intakeMotorA.set(1.0);
			CMap.intakeMotorB.set(1.0);
		} else {
			CMap.intakeMotorA.set(0);
			CMap.intakeMotorB.set(0);
		}
	}
}
