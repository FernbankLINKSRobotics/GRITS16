package autonomous;

import org.usfirst.frc.team4468.robot.CMap;

public class Cheval {
	
	public static void cross(int position){
		if(!CMap.initialCrossComplete){
			CMap.leftPID.setSetpoint(156);
			CMap.rightPID.setSetpoint(156);
			if(CMap.leftPID.getPosition() > 154){
				CMap.initialCrossComplete = true;
			}
		//Lining Up the Robot
			
		} else if (!CMap.linedUp){
			/*
			table = NetworkTable.getTable("GRIP/myContoursReport");
			CMap.linedUp = AutoAim.aim(NetworkTable.getTable("GRIP/myContoursReport"), "left");
			*/
			
			//Lining up with encoders because the robot's
			//orientation doesn't change drastically.
			switch(position){
			case 2:
				CMap.leftPID.getPIDController().setSetpoint(0);
				CMap.rightPID.getPIDController().setSetpoint(0);
				break;
			case 3:
				CMap.leftPID.getPIDController().setSetpoint(0);
				CMap.rightPID.getPIDController().setSetpoint(0);
				break;
			case 4:
				CMap.leftPID.getPIDController().setSetpoint(0);
				CMap.rightPID.getPIDController().setSetpoint(0);
				break;
			case 5:
				CMap.leftPID.getPIDController().setSetpoint(0);
				CMap.rightPID.getPIDController().setSetpoint(0);
				break;
			}
		} else {
			CMap.leftPID.getPIDController().disable();
			CMap.rightPID.getPIDController().disable();
		}
		
		
	}
}
