package autonomous;
import org.usfirst.frc.team4468.robot.CMap;

import edu.wpi.first.wpilibj.Timer;
import shooter.Launch;

public class Moat {	
	private static boolean crossed = false;
	private static boolean aimed = false;
	private static boolean shot = false;
	private static double angle = 0;
	
	public static void cross(int position){
		if(!crossed){
			CMap.leftDrivePID.getPIDController().setSetpoint(120);
			if(CMap.leftDrivePID.getPIDController().onTarget()){
				crossed = true;
				CMap.leftDrivePID.getPIDController().disable();
				CMap.rightDrivePID.getPIDController().disable();
				System.out.println("Left & Right Drive PIDs disabled at " + Timer.getMatchTime());
				CMap.turnPID.getPIDController().enable();
				System.out.println("Turn Controller PID enabled at " + Timer.getMatchTime());
				CMap.gyro.reset();
				
			}
		} else if(!aimed && crossed){
			CMap.shooterPID.getPIDController().setSetpoint(5);
			switch(position){
			case 2:
				angle = 0;
				break;
			case 3:
				angle = 0;
				break;
			case 4:
				angle = 0;
				break;
			case 5:
				angle = 0;
				break;
			}
			CMap.turnPID.getPIDController().setSetpoint(angle);
			if(CMap.turnPID.getPIDController().onTarget() && CMap.shooterPID.getPIDController().onTarget()){
				aimed = true;
				CMap.turnPID.getPIDController().disable();
				System.out.println("Turn Controller PID disabled at " + Timer.getMatchTime());
			}
		} else if(crossed && aimed && !shot){
			Launch.autoShoot();
			CMap.shooterPID.getPIDController().setSetpoint(1);
			shot = true;
			System.out.println("Shot fired at " + Timer.getMatchTime());
			System.out.println("Shooter resetting to normal position.");
		}
	}
	
}


