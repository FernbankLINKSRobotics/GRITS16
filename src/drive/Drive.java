package drive;
import org.usfirst.frc.team4468.robot.CMap;
import drive.*;
import edu.wpi.first.wpilibj.*;
public class Drive {

	public static void drive(){
		Shift.shift();
		Wedge.change();
		CMap.leftDrive.set(CMap.leftJoystick.getY() * -1);
		CMap.rightDrive.set(CMap.rightJoystick.getY() * -1);
	}
}
