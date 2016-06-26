package vision;
import org.usfirst.frc.team4468.robot.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.networktables.*;
public class AutoAim {
	static double[] defaultValue = new double[0];
	
	public static void aim(NetworkTable table, 
			String target){
		double[] areas = table.getNumberArray("area", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double[] centerY = table.getNumberArray("CenterY", defaultValue);
		
		/*
		 * (0,0) = Top Left Corner of Camera Screen
		 */

	}
}
