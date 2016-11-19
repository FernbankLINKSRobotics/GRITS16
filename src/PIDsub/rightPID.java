package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

import org.usfirst.frc.team4468.robot.CMap;

import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class rightPID extends PIDSubsystem {
	private static final double Kp = .2;
	private static final double Ki = 0;
	private static final double Kd = 0;
	
    // Initialize your subsystem here
    public rightPID() {
        super("rightPID", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	return CMap.rightDriveEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
    	CMap.rightDrive.set(output);
    }
}
