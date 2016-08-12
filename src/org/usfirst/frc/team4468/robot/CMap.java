package org.usfirst.frc.team4468.robot;
import edu.wpi.first.wpilibj.*;

import com.kauailabs.navx.frc.AHRS;

import PIDsub.*;

public class CMap {
	public static boolean initialCrossComplete;
	public static boolean linedUp;
	public static boolean launched;
	public static boolean backInNeutral;
	public static boolean visionAimed;
	public static boolean encoderLinedUpMessageSent;
	public static int timeSinceLaunch;
	public static boolean gyroInitialized;
	
    public static final double wheelDiameter = 6;
    public static final double pulsePerRevolution = 360;
    public static final double encoderGearRatio = 3;
    public static final double gearRatio = 64.0/20.0;
    public static final double Fudgefactor = 1.0;
    
    private final static double distancePerPulse = Math.PI*wheelDiameter/pulsePerRevolution /
    		encoderGearRatio/gearRatio * Fudgefactor;
    
	public static Joystick leftJoystick;
	public static Joystick rightJoystick;
	public static Joystick armJoystick;
	
	public static Talon leftDriveTalon;
	public static Talon rightDriveTalon;
	public static Talon shooterArmTalon;
	public static Talon shooterLeftTalon;
	public static Talon shooterRightTalon;
	
	public static RobotDrive PIDRobotDrive;
	
	public static Encoder leftDriveEncoder;
	public static Encoder rightDriveEncoder;
	
	public static AHRS Gyro;
	
	public static leftPID leftPID;
	public static rightPID rightPID;
	public static shooterArmPID armPID;
	public static turnController turnController;
	
	
	
	public static Compressor compressor;
	
	public static Solenoid leftGearShift, rightGearShift;
	public static Solenoid shooterPunch;
	
	
	
	
	
	public static void initialize(){
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		armJoystick = new Joystick(2);
		
		leftDriveTalon = new Talon(0);
		rightDriveTalon = new Talon(1);
		shooterArmTalon = new Talon(2);
		shooterLeftTalon = new Talon(3);
		shooterRightTalon = new Talon(4);
		
		leftGearShift = new Solenoid(1);
		rightGearShift = new Solenoid(2);
		shooterPunch = new Solenoid(3);
		
		leftDriveTalon.setInverted(true);
		
		leftDriveEncoder = new Encoder(0, 1);
		rightDriveEncoder = new Encoder(2, 3);
		
		
		leftDriveEncoder.setReverseDirection(true);
		
		leftDriveEncoder.reset();
		rightDriveEncoder.reset();
		
		leftDriveEncoder.setDistancePerPulse(distancePerPulse);
		rightDriveEncoder.setDistancePerPulse(distancePerPulse);
		
		try{
			Gyro = new AHRS(SPI.Port.kMXP);
			Gyro.reset();
			gyroInitialized = true;
		} catch(RuntimeException e){
			DriverStation.reportError("Error Communicating with Gyro:" + e.getMessage(), true);
			gyroInitialized = false;
		}
		
		leftPID = new leftPID();
		rightPID = new rightPID();
		armPID = new shooterArmPID();
		if(gyroInitialized){
			turnController = new turnController();
			turnController.getPIDController().setInputRange(-180.0f, 180.0f);
			turnController.getPIDController().setOutputRange(-1.0, 1.0);
			turnController.getPIDController().disable();
		}
		
		PIDRobotDrive = new RobotDrive(leftDriveTalon, rightDriveTalon);
		

		
		
		compressor = new Compressor();
		
		compressor.setClosedLoopControl(true);
		
		initialCrossComplete = false;
		linedUp = false;
		launched = false;
		backInNeutral = false;
		encoderLinedUpMessageSent = false;
		
		System.out.println("All values are initialized");
		
	}
}
