
package org.usfirst.frc.team4468.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4468.robot.*;

import autonomous.*;
import drive.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Low Bar";
    final String customAuto = "My Auto";
	SendableChooser autoDefenseChooser;
	SendableChooser autoPositionChooser;
	
	
    public void robotInit() {
    	CMap.initialize();
    	
    	autoDefenseChooser = new SendableChooser();
        autoDefenseChooser.addDefault("Low Bar", defaultAuto);
        autoDefenseChooser.addObject("Cheval", "Cheval");
        autoDefenseChooser.addObject("Ramparts", "Ramparts");
        autoDefenseChooser.addObject("Rock Wall", "Rock Wall");
        autoDefenseChooser.addObject("Rough Terrain", "Rough Terrain");
        
        autoPositionChooser = new SendableChooser();
        autoPositionChooser.addDefault("1", 1);
        autoPositionChooser.addObject("2", 2);
        autoPositionChooser.addObject("3", 3);
        autoPositionChooser.addObject("4", 4);
        autoPositionChooser.addObject("5", 5);
        
        SmartDashboard.putData("Which Defense?", autoDefenseChooser);
        SmartDashboard.putData("Which Position?", autoPositionChooser);
    }
    
    public void autonomousInit(){

	}
    	
    
    public void autonomousPeriodic(){
    	String autoDefense = (String) autoDefenseChooser.getSelected();
    	Integer autoPosition = (Integer) autoPositionChooser.getSelected();
    	
    	switch (autoDefense){
    	case "Low Bar":
    		LowBar.cross();
    		break;
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
    	
    }
    
    public void teleopPeriodic(){
    	Drive.drive();
    	Shift.shiftDrive();
    }
    
    public void disabledInit(){
    	
    }
    
    public void disabledPeriodic(){
    	
    }
    
}
