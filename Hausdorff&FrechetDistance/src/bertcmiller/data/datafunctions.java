package bertcmiller.data;

import java.util.ArrayList;
import java.util.Collections;

public class datafunctions {
	public static double hausdorffDistance(ArrayList<Double> series1, ArrayList<Double> series2){
		ArrayList<Double> distances2 = new ArrayList<>(); //An arraylist that will contain all of the minimum distances 
		double minDis = 0.0;
		int constant = 1; //Used as a substitution for horizontal distance in timeseries data.  This assuming equal 'distance' between each observation and is arbitrarily set as 1.
		
		for (int i = 0; i <series1.size(); i++) {
			ArrayList<Double> distances = new ArrayList<>(); //Contains all of the distances for a particular set of calculations 
			for(int j = 0; j < series2.size(); j++) {
				double dist = Math.sqrt(Math.pow((j - i) * constant, 2) + Math.pow(series1.get(i)- series2.get(j), 2)); //Using Euclidean distance (C^2 = A^2 + B^2)
				distances.add(dist);
			}			
			minDis = Collections.min(distances);
			distances2.add(minDis);
		}
		
		double hausdorffDistance = Collections.max(distances2);
		return hausdorffDistance;
		
	}
	
	public static double fretchetDistance(ArrayList<Double> series1, ArrayList<Double> series2){
		ArrayList<Double> distances2 = new ArrayList<>(); //Contains all of the maximum distances from each series of calculations
		double maxDis = (0.0);
		int constant = 1; //Used as a substitution for horizontal distance in timeseries data.  This assuming equal 'distance' between each observation and is arbitrarily set as 1.
		
		for (int i =0; i < series1.size(); i++){
			ArrayList<Double> distances = new ArrayList<>(); //Contains all of the distances for a particular set of calculations 
			for (int j = 0; j < series2.size(); j++){
				double dist = Math.sqrt(Math.pow((j - i) * constant , 2) + Math.pow(series1.get(i) - series2.get(j), 2)); //Using Euclidean distance (C^2 = A^2 + B^2)
				distances.add(dist);
			}
			maxDis = Collections.max(distances);
			distances2.add(maxDis);
		}
		
		double fretchetDistance = Collections.min(distances2);
		return fretchetDistance;
	}
	
}
