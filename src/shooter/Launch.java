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
		if(!DriverStation.getInstance().isAutonomous()){
			//This will run in teleoperated mode
			if(CMap.armJoystick.getTrigger()){
				if(!beenPressed){
					//If the wheels aren't spinning
					if(!wheelsAreMoving && !launched){
						wheelsAreMoving = true;
						speedUpWheels();
						System.out.println("I'm spinning my wheels."
								+ "Press the trigger again to fire!");
					} else if(wheelsAreMoving && !launched){
						CMap.shooterPunch.set(true);
						System.out.println("Fired Boulder!");
						System.out.println("Press the trigger again to reset");
						launched = true;
					} else if(launched){
						//RESET
						speedUpWheels();
						wheelsAreMoving = false;
						CMap.shooterPunch.set(false);
						launched = false;
					}
					beenPressed = !beenPressed;
				}
				beenPressed = true;
			} else {
				beenPressed = false;
			}
		} else if(DriverStation.getInstance().isAutonomous()){
			//This will run in autonomous mode
			wheelsAreMoving = !wheelsAreMoving;
			speedUpWheels();
			Timer.delay(1);
			CMap.shooterPunch.set(true);
			Timer.delay(1);
			CMap.shooterPunch.set(false);
			speedUpWheels();
		}
			

	}
	
	public static void speedUpWheels(){
		if(wheelsAreMoving){
			CMap.shooterLeftTalon.set(1.0);
			CMap.shooterRightTalon.set(1.0);
		} else if(!wheelsAreMoving){
			CMap.shooterLeftTalon.set(0);
			CMap.shooterRightTalon.set(0);
		}
	}
}
