
package org.usfirst.frc.team4468.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4468.robot.*;

import drive.*;
import shooter.*;
import vision.*;


public class Robot extends IterativeRobot {
    final String defaultAuto = "Low Bar";
	SendableChooser autoDefenseChooser;
	SendableChooser autoPositionChooser;
	private boolean firstTest = false;
	private double differenceBetweenSamples = 0;
	private double lastSample = 0.0;
	private double headingDifference;
	private boolean stopped = false;
	
	
    public void robotInit() {
    	CMap.initialize();
    }
    
    public void autonomousInit(){
    	
	}
    	
    
    public void autonomousPeriodic(){
    	
    }
    
    public void teleopInit(){
    	
    	CMap.turnPID.getPIDController().disable();
		CMap.leftDrivePID.getPIDController().disable();
		CMap.rightDrivePID.getPIDController().disable();
    }
    
    public void teleopPeriodic(){
    	Drive.drive(); //Driving & Shifting
    	
    	Load.changeIntakePosition();
    	Load.spinPneumaticIntakeWheels();
    	
    	//System.out.println(CMap.shooterArmEncoder.getDistance());
    	
    	VerticalAim.aim();
    	
    	Launch.shootBoulder();
    	
    	//System.out.println(CMap.gyro.pidGet());

    	/*
		System.out.println("Left " + String.valueOf(CMap.leftDriveEncoder.get()));
		System.out.println("Right " + String.valueOf(CMap.rightDriveEncoder.get()));
    	*/
    }
    
    public void disabledInit(){

    	CMap.leftDriveEncoder.reset();
    	CMap.rightDriveEncoder.reset();
    }
    
    public void disabledPeriodic(){
    	CMap.leftDriveEncoder.reset();
    	CMap.rightDriveEncoder.reset();
    }
    
    public void testInit(){
    	CMap.leftDrivePID.getPIDController().enable();
    	CMap.rightDrivePID.getPIDController().enable();
    	CMap.leftDriveEncoder.reset();
    	CMap.rightDriveEncoder.reset();
    	CMap.gyro.reset();
    }
    
    public void testPeriodic(){
    	System.out.println(CMap.leftDriveEncoder.getDistance());
    	System.out.println(CMap.rightDriveEncoder.getDistance());
    	}
    
}
