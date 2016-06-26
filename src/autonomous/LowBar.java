package autonomous;
import org.usfirst.frc.team4468.robot.*;
import vision.*;

public class LowBar {
	public static void cross(){
		if(!CMap.initialCrossComplete){
			CMap.leftPID.setSetpoint(156);
			CMap.rightPID.setSetpoint(156);
			if(CMap.leftPID.onTarget()){
				CMap.initialCrossComplete = true;
			}
		} else if (!CMap.linedUp){
			CMap.leftPID.setSetpoint(177);
			if(CMap.leftPID.getPosition() >= 175){
				CMap.linedUp = true;
			}
		} else {
			CMap.leftPID.disable();
			CMap.rightPID.disable();
		}
		
		
		
	}
}
