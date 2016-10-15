package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team4468.robot.*;

/**
 *
 */
public class leftPID extends PIDSubsystem {
	private static final double Kp = .2;
	private static final double Ki = 0;
	private static final double Kd = 0;
	
    // Initialize your subsystem here
    public leftPID() {
        super("leftPID", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	return CMap.leftDriveEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
    	CMap.leftDrive.set(output);
    }
}
