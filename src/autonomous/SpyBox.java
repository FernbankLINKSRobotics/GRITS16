package autonomous;

import org.usfirst.frc.team4468.robot.CMap;

public class SpyBox {
	
	public static void execute(double time){
		if(time >= 5.0){
			CMap.intakeMotorA.set(-1.0);
			CMap.intakeMotorB.set(-1.0);
			if(time >= 10){
				CMap.intakeMotorA.set(0);
    			CMap.intakeMotorB.set(0);
			}
		}
	}

}
