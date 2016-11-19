package org.usfirst.frc.team4468.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.vision.USBCamera;
import PIDsub.*;

public class CMap {
	public static final double turnCoefficient = .2261;
	public static boolean aiming = false;
	public static boolean aimed = false;
	public static boolean inMotion = false; //Shooting Motion
	
	public static Timer autoTimer;
	public static Timer teleopTimer;
	
	
	//Input Devices
	public static Joystick leftJoystick, rightJoystick, auxJoystick;
	public static Compressor compressor;
	
	//Drive System
	public static Talon leftDrive, rightDrive;
	public static Encoder leftDriveEncoder, rightDriveEncoder;
	public static DoubleSolenoid gearShift;
	public static Solenoid leftShift, rightShift;
	
	 //Camera
	public static CameraServer server;
	
	//public static RobotDrive drivetrain;
	
	//Shooting System
	public static Encoder wedgeEncoder;
	public static Talon intakeMotorA, intakeMotorB, wedgeMotor;
	public static DoubleSolenoid intakeSolenoid, shooterSolenoid;
	public static DigitalInput leftSwtich, rightSwitch;
	
	//PID Subsystems
	public static leftPID leftDrivePID;
	public static rightPID rightDrivePID;
	public static wedgePID wedgeArmPID;
	
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
		
		leftDriveEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		rightDriveEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		
		
		leftDriveEncoder.setDistancePerPulse(0.0175147928994083); //Inches
		rightDriveEncoder.setDistancePerPulse(0.0175147928994083); //Inches
				
		gearShift = new DoubleSolenoid(0, 1);
		
		//Shooting System Init
		intakeMotorA = new Talon(3); //Might be one of them
		intakeMotorB = new Talon(4);
		wedgeMotor = new Talon(2); //Invert Motor
		
		wedgeMotor.setInverted(true);
		
		intakeSolenoid = new DoubleSolenoid(2, 3);
		shooterSolenoid = new DoubleSolenoid(4, 5);
		
		wedgeEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
		wedgeEncoder.reset();
		wedgeEncoder.setDistancePerPulse(.02 * 3.5999999999);
		
		compressor = new Compressor();
		compressor.setClosedLoopControl(true);
		
		/*
		leftSwtich = new DigitalInput(6);
		rightSwitch = new DigitalInput(7);
		*/
		//PID Initialization
		wedgeArmPID = new wedgePID();
		leftDrivePID = new leftPID(); //360 degrees / 81.4 inches = 4.4226 degrees per inch
		//81.4 inches / 360 degrees = .2261 inches per degree
		rightDrivePID = new rightPID();
		
		
		wedgeArmPID.getPIDController().disable();
		leftDrivePID.getPIDController().disable();
		rightDrivePID.getPIDController().disable();
		
		
		wedgeArmPID.getPIDController().setOutputRange(-.25, .25);
		leftDrivePID.getPIDController().setOutputRange(-.6, .6);
		rightDrivePID.getPIDController().setOutputRange(-.6, .6);
		
		wedgeArmPID.getPIDController().setPercentTolerance(1);
		leftDrivePID.getPIDController().setAbsoluteTolerance(1);
		
		autoTimer = new Timer();
		teleopTimer = new Timer();
		
		autoTimer.stop();
		teleopTimer.stop();
		
		autoTimer.reset();
		teleopTimer.reset();
		
		
		//Camera
		
		server = CameraServer.getInstance();
		server.startAutomaticCapture("cam0");
		
		
		
	}
}
