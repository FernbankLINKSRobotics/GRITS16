package drive;

import org.usfirst.frc.team4468.robot.CMap;

public class Wedge {
	private static String position = "up";
	private static boolean beenPressed = false;
	public static void change(){
		if(CMap.auxJoystick.getRawButton(11) || CMap.auxJoystick.getRawButton(10)){
			if(!beenPressed){
				if(position == "up"){
					position = "down";
					
				} else if(position == "down"){
					position = "up";
				}
				
				System.out.println("Wedge moved " + position + " at " + CMap.teleopTimer.get() + " seconds.");
			}
			beenPressed = true;
		} else {
			beenPressed = false;
		}
		
		if(position == "up"){
			CMap.wedgeArmPID.getPIDController().setSetpoint(30);
		} else if(position == "down"){
			CMap.wedgeArmPID.getPIDController().setSetpoint(90); //90, 60, OR 30
		}
	}
	
	public static void change(String newPosition){
		if(newPosition == "up"){
			CMap.wedgeArmPID.getPIDController().setSetpoint(20);
		} else if(newPosition == "down"){
			CMap.wedgeArmPID.getPIDController().setSetpoint(20);
		}
		position = newPosition;
	}
}
