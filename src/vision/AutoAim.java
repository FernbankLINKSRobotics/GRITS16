package vision;
import org.usfirst.frc.team4468.robot.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.networktables.*;
public class AutoAim {
	static double[] defaultValue = new double[0];
	
	
	/*
	 * So the way GRIP works is that it will run a
	 * special algorithim where wit will pick up the
	 * outlines of the target. These outlines are also
	 * known as contours, and we have GRIP filtering
	 * them based on color, area, and the x-coordinate.
	 */
	public static boolean aim(NetworkTable table, 
			String target){
		double[] areas = table.getNumberArray("area", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double[] centerY = table.getNumberArray("CenterY", defaultValue);
		int targetIndex;
		/*
		 * (0,0) = Top Left Corner of Camera Screen
		 * 
		 * 
		 */
		
		
		for(int i = 0; i < areas.length; i++){
			if(areas[i] > 0 && centerX[i] >= 200 && centerX[i] <= 150 && centerY[i] > 200 ){
				CMap.visionLinedUp = true;
			} else {
				CMap.visionLinedUp = false;
			}
		}
		return CMap.visionLinedUp;
		
		
	}
}
