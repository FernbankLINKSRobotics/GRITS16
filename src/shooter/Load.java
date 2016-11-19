package shooter;

import org.usfirst.frc.team4468.robot.CMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Load {
	private static boolean intakeBeenPressed = true;
	private static boolean loadingBeenPressed = false;
	private static boolean loading = false;
	private static boolean loaded = false;
	private static String intakePosition = "up";
	private static boolean firstRun = true;
	public static void changeIntakePosition(){
		
		 if(CMap.auxJoystick.getTrigger()){
		 	if(!intakeBeenPressed){
		 		if(intakePosition == "up"){
		 			intakePosition = "down";
		 			System.out.println("Intake Position set to " + intakePosition + " at " + CMap.teleopTimer.get() + " seconds.");
		 		} else if(intakePosition == "down"){
		 			intakePosition = "up";
		 		}
		 	}
		 	
		 	intakeBeenPressed = true;
		 } else {
		 	intakeBeenPressed = false;
		 }
		 
		
		if(intakePosition == "up"){
			CMap.intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
		} else if(intakePosition == "down"){
			CMap.intakeSolenoid.set(DoubleSolenoid.Value.kForward);
		}
	}
	
	public static void spinPneumaticIntakeWheels(){
		if(CMap.rightJoystick.getTrigger() || CMap.auxJoystick.getRawButton(8)){
			CMap.intakeMotorA.set(-1.0);
			CMap.intakeMotorB.set(-1.0);
			
		} else if(CMap.rightJoystick.getRawButton(9)){
			//Spin out of Intake
			CMap.intakeMotorA.set(1.0);
			CMap.intakeMotorB.set(1.0);
		} else {
			CMap.intakeMotorA.set(0);
			CMap.intakeMotorB.set(0);
		}
		
	}
	

}
