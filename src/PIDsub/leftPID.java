package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team4468.robot.*;

/**
 *
 */
public class leftPID extends PIDSubsystem {
	private static final int Kp = 1;
	private static final int Ki = 0;
	private static final int Kd = 0;
	
    // Initialize your subsystem here
    public leftPID() {
        super("leftPID", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	double leftDistance = CMap.leftDriveEncoder.getDistance();
    	return leftDistance;
    }
    
    protected void usePIDOutput(double output) {
    	CMap.leftDriveTalon.set(output);
    }
}
