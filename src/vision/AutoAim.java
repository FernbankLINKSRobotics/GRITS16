package vision;
import org.usfirst.frc.team4468.robot.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.networktables.*;
public class AutoAim {
	static double[] defaultValue = new double[0];
	
	/*
	 * So the way GRIP works is that it will run a
	 * special algorithm where wit will pick up the
	 * outlines of the target. These outlines are also
	 * known as contours, and we have GRIP filtering
	 * them based on color, area, and the x-coordinate.
	 */
	public static boolean visionLinedUp(NetworkTable table){
		double[] areas = table.getNumberArray("area", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double[] centerY = table.getNumberArray("CenterY", defaultValue);

		for(int i = 0; i < areas.length; i++){
			if(areas[i] > 0 && 
					centerX[i] >= 200 && centerX[i] <= 150 &&
					centerY[i] > 200 ){
				CMap.visionAimed = true;
			} else {
				CMap.visionAimed = false;
			}
		}
		return CMap.visionAimed;
	}
	
	public static void visionAim(NetworkTable table){
		double[] areas = table.getNumberArray("area", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double[] centerY = table.getNumberArray("CenterY", defaultValue);
		int targetIndex;
		
		for(int i = 0; i < areas.length; i++){
			
		}
	}
}
