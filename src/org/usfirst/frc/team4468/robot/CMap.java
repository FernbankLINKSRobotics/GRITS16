package org.usfirst.frc.team4468.robot;
import edu.wpi.first.wpilibj.*;


import PIDsub.*;

public class CMap {
	//Input Devices
	public static Joystick leftJoystick, rightJoystick, auxJoystick;
	public static Compressor compressor;
	
	//Drive System
	public static Talon leftDrive, rightDrive;
	public static AnalogGyro gyro;
	public static Encoder leftDriveEncoder, rightDriveEncoder;
	public static DoubleSolenoid gearShift;
	public static Solenoid leftShift, rightShift;
	
	//public static RobotDrive drivetrain;
	
	//Shooting System
	public static Encoder shooterArmEncoder;
	public static Talon intakeMotorA, intakeMotorB, shooterMotor, shooterArmMotor;
	public static DoubleSolenoid intakeSolenoid;
	public static DigitalInput leftSwtich, rightSwitch;
	
	//PID Subsystems
	public static leftPID leftDrivePID;
	public static rightPID rightDrivePID;
	public static shooterArmPID shooterPID;
	public static turnController turnPID;
	
	//TEST COMPONENTS
	public static Talon testMotor;
	
	public static void initialize(){
		//Input Device Init
		
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		auxJoystick = new Joystick(2);
	
		//Drive System Init
		leftDrive = new Talon(1);
		rightDrive = new Talon(0);
		
		leftDrive.setInverted(true);
		
		gyro = new AnalogGyro(0);
		gyro.setSensitivity(0.007);
		gyro.calibrate();
		gyro.reset();
		
		leftDriveEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		rightDriveEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		
		
		leftDriveEncoder.setDistancePerPulse(0.0175147928994083); //Inches
		rightDriveEncoder.setDistancePerPulse(0.0175147928994083); //Inches
				
		gearShift = new DoubleSolenoid(0, 1);
		
		//Shooting System Init
		intakeMotorA = new Talon(3); //Might be one of them
		intakeMotorB = new Talon(4);
		shooterMotor = new Talon(7);
		shooterArmMotor = new Talon(2); //Invert Motor
		
		shooterArmMotor.setInverted(true);
		
		intakeSolenoid = new DoubleSolenoid(2, 3);
		
		shooterArmEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
		shooterArmEncoder.reset();
		shooterArmEncoder.setDistancePerPulse(.043755697356427);
		
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		
		/*
		leftSwtich = new DigitalInput(6);
		rightSwitch = new DigitalInput(7);
		*/
		//PID Initialization
		shooterPID = new shooterArmPID();
		leftDrivePID = new leftPID();
		rightDrivePID = new rightPID();
		turnPID = new turnController();
		
		shooterPID.getPIDController().enable();
		leftDrivePID.getPIDController().enable();
		rightDrivePID.getPIDController().enable();
		turnPID.getPIDController().disable();
		
		
		shooterPID.getPIDController().setOutputRange(-.7, .7);
		leftDrivePID.getPIDController().setOutputRange(-.2, .2);
		rightDrivePID.getPIDController().setOutputRange(-.2, .2);
		turnPID.getPIDController().setOutputRange(-0.4, .4);
		
		leftDrivePID.getPIDController().setAbsoluteTolerance(1);
		
		turnPID.setInputRange(-180.0, 180.0);
		
		
		
		
		
		
	}
}
