package vision;
import java.util.ArrayList;
import java.util.Collections;

import org.usfirst.frc.team4468.robot.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.networktables.*;
import shooter.Launch;

public class AutoAim {
	/*
	 * Logitech Camera has a 69 degree FOV
	 * 
	 * We are using 640x480 Resolution (columns x rows)
	 * 
	 * 
	 */
	private NetworkTable contoursGRIP;
	private static int indexOfContour;
	
	private static final double idealCenterX = 0;
	private static final double idealCenterY = 0;
	
	private static double centerX;
	private static double centerY;
	
	private static double xOffset;
	private static double yOffset;
	
	private static double[] defaultValue = {0};
	private static ArrayList<Double> centerOfContour = new ArrayList<Double>();
	public static int findBiggest(NetworkTable contours){
		//An ArrayList that will hold the areas of the contours
		ArrayList<Double> returnArray = new ArrayList<Double>();
		
		//The array holding the areas, can't be sorted
		double[] areaArray = contours.getNumberArray("area", defaultValue);
		
		//The index of the largest contour
		int indexOfLargestContour = 0;
		
		for(double area : areaArray){
			//Add the area to the return array
			returnArray.add(area);
		}
		//Sort the array from largest to smallest
		Collections.sort(returnArray, Collections.reverseOrder());
		
		//This for loop looks for the largest contour and saves the index
		for(int i = 0; i < areaArray.length - 1; i++){
			if(areaArray[i] == returnArray.get(0)){
				indexOfLargestContour = i;
			}
		}
		
		return indexOfLargestContour;
		
	}

	//X, Y
	public static ArrayList<Double> findCenter(int index, NetworkTable contours){
		ArrayList<Double> contourCenter = new ArrayList<Double>();
		double[] centerXArray = contours.getNumberArray("centerX", defaultValue);
		double[] centerYArray = contours.getNumberArray("centerX", defaultValue);
		contourCenter.add(centerXArray[index]);
		contourCenter.add(centerYArray[index]);
		return contourCenter;
		
	}

	public static void aim(){
		indexOfContour = findBiggest(NetworkTable.getTable("GRIP/myContoursReport"));
		
		centerOfContour = findCenter(indexOfContour, NetworkTable.getTable("GRIP/myContoursReport"));
		
		centerX = centerOfContour.get(0);
		centerY = centerOfContour.get(1);
		
		xOffset = centerX - idealCenterX;
		yOffset = centerY - idealCenterY;
		
		if(Math.abs(xOffset) <= 2 && Math.abs(yOffset) <= 2){
			Launch.autoShoot();
		} else {
			//Convert Offset to Pixel Difference
			//Or Keep Motors Moving
		}
	}
}
