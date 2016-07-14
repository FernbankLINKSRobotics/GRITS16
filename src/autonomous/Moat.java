package autonomous;
import org.usfirst.frc.team4468.robot.CMap;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import vision.*;
public class Moat {
	/*
	 * Robot seems to stay straight
	 */
	static NetworkTable table;

	
	public static void cross(int goalPosition){
		//Initial Cross
		if(!CMap.initialCrossComplete){
			CMap.leftPID.setSetpoint(156);
			CMap.rightPID.setSetpoint(156);
			if(CMap.leftPID.getPosition() > 154){
				CMap.initialCrossComplete = true;
			}
		//Lining Up the Robot
		} else if (!CMap.linedUp){
			table = NetworkTable.getTable("GRIP/myContoursReport");
			CMap.linedUp = AutoAim.aim(NetworkTable.getTable("GRIP/myContoursReport"), "left");
		} else {
			CMap.leftPID.getPIDController().disable();
			CMap.rightPID.getPIDController().disable();
		}
	}
}


