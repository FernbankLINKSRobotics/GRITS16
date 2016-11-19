
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
import autonomous.*;


public class Robot extends IterativeRobot {
	private static int count = 0;
	private static String autoChoice = "cross";
	SendableChooser autoDefenseChooser;
	private static String defense = "";
	
    public void robotInit() {
    	CMap.initialize();

    	
       	autoDefenseChooser = new SendableChooser();
       	autoDefenseChooser.addDefault("Low Bar", "Low Bar");
        autoDefenseChooser.addObject("Cheval", "Cheval"); //Only Category B Defense
        autoDefenseChooser.addObject("Log Roll", "Log Roll"); //Other Category B
        autoDefenseChooser.addObject("Ramparts", "Ramparts"); //One of Two Category C
        autoDefenseChooser.addObject("Moat", "Moat"); //One of Two Category C
        autoDefenseChooser.addObject("Rock Wall", "Rock Wall"); // One of Two Category D 
        autoDefenseChooser.addObject("Rough Terrain", "Rough Terrain"); //One of Two Category D
        autoDefenseChooser.addObject("Score from Spy Box?", "Spy Box");
        
        SmartDashboard.putData("Which Defense?", autoDefenseChooser);
    	
    }
    
    public void autonomousInit(){
    	CMap.autoTimer.start();
    	
    	CMap.leftDrive.set(1);
    	CMap.rightDrive.set(1);
	}
    	
    
    public void autonomousPeriodic(){
    	/*
    	if(defense == "Spy Box"){
    		SpyBox.execute(CMap.autoTimer.get());
    	} else if(defense == "Cheval"){
    		Cheval.cross(CMap.autoTimer.get());
    	} else {
    		if(CMap.autoTimer.get() >= 5){
    			CMap.leftDrive.set(0);
    	    	CMap.rightDrive.set(0);
    		} else {
    			CMap.leftDrive.set(1.0);
    	    	CMap.rightDrive.set(1.0);
    		}
    	}*/
    	
    	if(CMap.autoTimer.get() >= 3.5){
    		CMap.leftDrive.set(.3);
    		CMap.rightDrive.set(.3);
    		if(CMap.autoTimer.get() >= 6){
    			CMap.leftDrive.set(0);
    			CMap.rightDrive.set(0);
    		}
    	}
    }
    
    public void teleopInit(){
		CMap.leftDrivePID.getPIDController().disable();
		CMap.rightDrivePID.getPIDController().disable();
		CMap.autoTimer.stop();
		CMap.teleopTimer.reset();
		CMap.teleopTimer.start();
    }
    
    public void teleopPeriodic(){
    		Drive.drive(); //Driving & Shifting & Wedging
    		Load.changeIntakePosition();
    		Load.spinPneumaticIntakeWheels();
    		
    }
    
    public void disabledInit(){
    }
    
    public void disabledPeriodic(){
    }
    
    public void testInit(){
    	System.out.println("Timer Reset");
    	CMap.teleopTimer.reset();
    	CMap.teleopTimer.stop();
    	CMap.teleopTimer.start();
    }
    
    public void testPeriodic(){
    	CMap.wedgeArmPID.getPIDController().setSetpoint(800);
    	System.out.println("Encoder " + CMap.wedgeEncoder.get());
    }
    
}
