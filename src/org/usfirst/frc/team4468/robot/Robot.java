
package org.usfirst.frc.team4468.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4468.robot.*;

import autonomous.*;
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
	
	
    public void robotInit() {
    	CMap.initialize();
    	
    	autoDefenseChooser = new SendableChooser();
        autoDefenseChooser.addObject("Cheval", "Cheval"); //Only Category B Defense
        autoDefenseChooser.addObject("Log Roll", "Log Roll");
        autoDefenseChooser.addObject("Ramparts", "Ramparts"); //One of Two Category C
        autoDefenseChooser.addObject("Moat", "Moat"); //One of Two Category C
        autoDefenseChooser.addObject("Rock Wall", "Rock Wall"); // One of Two Category D 
        autoDefenseChooser.addObject("Rough Terrain", "Rough Terrain"); //One of Two Category D
        
        
        autoPositionChooser = new SendableChooser();
        autoPositionChooser.addObject("2", 2);
        autoPositionChooser.addObject("3", 3);
        autoPositionChooser.addObject("4", 4);
        autoPositionChooser.addObject("5", 5);
        
        SmartDashboard.putData("Which Defense?", autoDefenseChooser);
        Timer.delay(1.5); //So they don't end up on top of each other
        SmartDashboard.putData("Which Position?", autoPositionChooser);
        
        System.out.println("The choosers should be on the Dashboard");
    }
    
    public void autonomousInit(){
    	
	}
    	
    
    public void autonomousPeriodic(){
    	String autoDefense = (String) autoDefenseChooser.getSelected();
    	Integer autoPosition = (Integer) autoPositionChooser.getSelected();
    	
    	System.out.println("Defense Chosen:" + autoDefense);
    	System.out.println("Position of Defense:" + autoPosition);
    	
    	switch (autoDefense){
    	case "Cheval":
    		Cheval.cross(autoPosition);
    		break;
    	case "Ramparts":
    		Ramparts.cross(autoPosition);
    		break;
    	case "Rock Wall":
    		RockWall.cross(autoPosition);
    		break;
    	case "Rough Terrain":
    		RoughTerrain.cross(autoPosition);
    		break;
    	case "Moat":
    		Moat.cross(autoPosition);
    		break;
    	}
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
    	
    }
    
    public void disabledPeriodic(){
    	
    }
    
    public void testInit(){
    	/*
    	CMap.turnPID.getPIDController().enable();
    	CMap.turnPID.getPIDController().setSetpoint(50);
    	*/
    	
    }
    
    public void testPeriodic(){
    }
    
}
