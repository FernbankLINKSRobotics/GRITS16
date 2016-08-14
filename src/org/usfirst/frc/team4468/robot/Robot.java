
package org.usfirst.frc.team4468.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
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
	
	
    public void robotInit() {
    	CMap.initialize();
    	
    	autoDefenseChooser = new SendableChooser();
        autoDefenseChooser.addObject("Cheval", "Cheval"); //Only Category B Defense
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
    	CMap.turnController.getPIDController().reset();
    }
    
    public void teleopPeriodic(){
    	Drive.drive();
    	Shift.shiftDrive();
    	Launch.shootBoulder();
    }
    
    public void disabledInit(){
    	
    }
    
    public void disabledPeriodic(){
    	
    }
    
    public void testPeriodic(){
    	LiveWindow.addSensor("Gyroscope", 1, CMap.gyro);
    }
    
}
