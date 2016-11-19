package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team4468.robot.CMap;

/**
 *
 */
public class wedgePID extends PIDSubsystem {
	private static final double Kp = .01; //.18
	private static final double Ki = 0;
	private static final double Kd = 0;
	
    // Initialize your subsystem here
    public wedgePID() {
        super("wedgePID", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
    	
    }
    
    protected double returnPIDInput() {
    	System.out.println("Input " + CMap.wedgeEncoder.getDistance());
    	return CMap.wedgeEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
    	System.out.println("Output " + output);
    	CMap.wedgeMotor.set(output);
    }
}
