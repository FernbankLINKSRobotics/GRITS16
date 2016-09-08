package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4468.robot.*;
/**
 *
 */
public class turnController extends PIDSubsystem {
	private static final double Kp = 0.03;
	private static final double Ki = 0;
	private static final double Kd = 0;
    // Initialize your subsystem here
    public turnController() {
        super("turnController", Kp, Ki, Kd);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	
    	return CMap.gyro.pidGet();
    }
    
    protected void usePIDOutput(double output) {
    	CMap.driveTrain.drive(0.2, output);
    }
}