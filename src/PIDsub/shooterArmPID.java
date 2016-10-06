package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team4468.robot.*;

/**
 *
 */
public class shooterArmPID extends PIDSubsystem {
	private static final int Kp = 1;
	private static final int Ki = 0;
	private static final int Kd = 0;
	
    // Initialize your subsystem here
    public shooterArmPID() {
        super("shooterArmPID", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {

    }
    
    protected double returnPIDInput() {
    	return 0;
    }
    
    protected void usePIDOutput(double output) {
    	
    }
}
