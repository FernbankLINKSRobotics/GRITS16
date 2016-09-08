package autonomous;

import org.usfirst.frc.team4468.robot.CMap;

public class Cheval {
	
	public static void cross(int position){
		//Will run first
		if(!CMap.initialCrossComplete){
			CMap.leftPID.setSetpoint(156);
			CMap.rightPID.setSetpoint(156);
			CMap.driveTrain.tankDrive(CMap.PIDLeftValue, CMap.PIDRightValue);
			if(CMap.leftPID.onTarget() && CMap.rightPID.onTarget()){
				CMap.initialCrossComplete = true;
			}
		//Lining Up the Robot
			//Second Case
		} else if (!CMap.linedUp){
			CMap.leftPID.getPIDController().disable();
			CMap.rightPID.getPIDController().disable();
			
			CMap.armPID.getPIDController().setSetpoint(100);
			
			switch(position){
			case 2:
				CMap.turnController.setSetpoint(100);
				break;
			case 3:
				CMap.turnController.setSetpoint(100);
				break;
			case 4:
				CMap.turnController.setSetpoint(100);
				break;
			case 5:
				CMap.turnController.setSetpoint(100);
				break;
			}
		} else if (!CMap.launched) {
			CMap.turnController.getPIDController().disable();
			CMap.armPID.getPIDController().setSetpoint(30);
		}
		
		
	}
}
