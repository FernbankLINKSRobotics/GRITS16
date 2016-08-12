package PIDsub;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team4468.robot.*;
/**
 *
 */
public class turnController extends PIDSubsystem {
	private static final int Kp = 0.03;
	private static final int Ki = 0;
	private static final int Kd = 0;
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
    	
    	return CMap.Gyro.pidGet();
    }
    
    protected void usePIDOutput(double output) {
    	CMap.PIDRobotDrive.drive(0.2, output);
    }
}
