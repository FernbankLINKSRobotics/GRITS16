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
		 		shootingBeenPressed = true;
		 		if(!wheelsSpinning){
		 			//If the wheels aren't spinning
		 			//First shooting motion
		 			spinWheels(true);
		 			wheelsSpinning = true;
		 		} else if(wheelsSpinning){
		 			//Pneumatic Punch
		 			System.out.println("Boulder launched");
		 			spinWheels(false);
		 			wheelsSpinning = false;
	 			}
		 	}
		 	
		 } else if(CMap.auxJoystick.getRawButton(2) && !abortBeenPressed){
		 	spinWheels(false);
		 	abortBeenPressed = true;
		 	System.out.println("Shooting motion aborted at ");
		 } else {
		 	abortBeenPressed = false;
		 	shootingBeenPressed = false;
		 }
		 
	}
	
	public static void spinWheels(boolean toSpin){
		if(toSpin){
			CMap.shooterMotor.set(1.0);
			System.out.println("Wheels starting to spin at ");
		} else {
			CMap.shooterMotor.set(0);
			System.out.println("Wheels starting to stop spinning at ");
		}
	}

	public static void autoShoot(){
		spinWheels(true);
		Timer.delay(3);
		//Pneumatic Punch
		System.out.println("Boulder launched at ");
		Timer.delay(2);
		spinWheels(false);
	}
}
