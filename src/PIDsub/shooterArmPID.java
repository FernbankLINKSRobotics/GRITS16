package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team4468.robot.CMap;

/**
 *
 */
public class shooterArmPID extends PIDSubsystem {
	private static final double Kp = .08; //.18
	private static final double Ki = 0;
	private static final double Kd = 0;
	
    // Initialize your subsystem here
    public shooterArmPID() {
        super("shooterArmPID", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
    	
    }
    
    protected double returnPIDInput() {
    	return CMap.shooterArmEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
    	CMap.shooterArmMotor.set(output);
    }
}
