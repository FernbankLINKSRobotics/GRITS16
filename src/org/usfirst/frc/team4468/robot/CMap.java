package org.usfirst.frc.team4468.robot;
import edu.wpi.first.wpilibj.*;


import PIDsub.*;

public class CMap {

	//Drive System
	
	
	AnalogGyro gyro;
	Encoder leftDrive, rightDrive;
	DoubleSolenoid gearShift;
	
	//Shooting System
	
	
	
	Encoder shooterArm;
	Talon intakeMotor;
	DoubleSolenoid intakeSolenoid;
	//TEST COMPONENTS
	public static Talon testMotor;
	
	public static void initialize(){
		testMotor = new Talon(0);
		
	}
}
