package shooter;

import org.usfirst.frc.team4468.robot.CMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Load {
	private static boolean intakeBeenPressed = true;
	private static boolean loadingBeenPressed = false;
	private static boolean loading = false;
	private static boolean loaded = false;
	private static String intakePosition = "up";
	public static void changeIntakePosition(){
		
		 if(CMap.rightJoystick.getTrigger()){
		 	if(!intakeBeenPressed){
		 		if(intakePosition == "up"){
		 			intakePosition = "down";
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
		if(CMap.rightJoystick.getRawButton(2)){
			CMap.intakeMotorA.set(1.0);
			CMap.intakeMotorB.set(1.0);
		} else if(CMap.rightJoystick.getRawButton(3)){
			//Spin out of Intake
			CMap.intakeMotorA.set(-1.0);
			CMap.intakeMotorB.set(-1.0);
		} else {
			CMap.intakeMotorA.set(0);
			CMap.intakeMotorB.set(0);
		}
		
	}
	
	public static void loadBoulderIntoShooter(){
		/*
		if(CMap.auxJoystick.getRawButton(3)){
			if(!loadingBeenPressed){
				if(CMap.shooterPID.getDistance() > 1){
					CMap.shooterPID.getPIDController().setSetpoint(.5);
				} else if(CMap.shooterPID.getDistance <= 1 && intakePosition == "up"){
					Spin Both Sets of Wheels
					Thus loading
					loading = true;
				} else if(loading){
					Stop Spinning Wheels;
					loading = false;
				}
			}
			loadingBeenPressed = true;
		} else {
			loadingBeenPressed = true;
		}*/
		
		if(CMap.auxJoystick.getRawButton(3)){
			CMap.intakeMotorA.set(1.0);
			CMap.intakeMotorB.set(1.0);
			CMap.shooterMotor.set(-1.0);
		}
		 
	}
}
