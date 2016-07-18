package org.usfirst.frc.team4468.robot;
import edu.wpi.first.wpilibj.*;
import PIDsub.*;

public class CMap {
	public static boolean initialCrossComplete;
	public static boolean linedUp;
	public static boolean launched;
	public static boolean backInNeutral;
	public static int timeSinceLaunch;
	
    public static final double wheelDiameter = 6;
    public static final double pulsePerRevolution = 360;
    public static final double encoderGearRatio = 3;
    public static final double gearRatio = 64.0/20.0;
    public static final double Fudgefactor = 1.0;
    
    final double distanceperpulse = Math.PI*wheelDiameter/pulsePerRevolution /
    		encoderGearRatio/gearRatio * Fudgefactor;
    
	public static Joystick leftJoystick;
	public static Joystick rightJoystick;
	public static Joystick armJoystick;
	
	public static Talon leftDriveTalon;
	public static Talon rightDriveTalon;
	public static Talon armTalon;
	public static Talon shooterArmTalon;
	public static Talon shooterLeftTalon;
	public static Talon shooterRightTalon;
	
	public static Encoder leftDriveEncoder;
	public static Encoder rightDriveEncoder;
	
	public static leftPID leftPID;
	public static rightPID rightPID;
	
	public static Compressor compressor;
	
	public static Solenoid leftGearShift, rightGearShift;
	
	
	
	
	
	public static void initialize(){
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
		armJoystick = new Joystick(2);
		
		leftDriveTalon = new Talon(0);
		rightDriveTalon = new Talon(1);
		armTalon = new Talon(2);
		shooterArmTalon = new Talon(3);
		shooterLeftTalon = new Talon(4);
		shooterRightTalon = new Talon(5);
		
		leftDriveTalon.setInverted(true);
		
		leftDriveEncoder = new Encoder(0, 1);
		rightDriveEncoder = new Encoder(2, 3);
		
		leftDriveEncoder.setReverseDirection(true);
		
		leftPID = new leftPID();
		rightPID = new rightPID();
		
		compressor = new Compressor();
		
		compressor.setClosedLoopControl(true);
		
		initialCrossComplete = false;
		linedUp = false;
		launched = false;
		backInNeutral = false;
		
	}
}
