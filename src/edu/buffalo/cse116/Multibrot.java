package edu.buffalo.cse116;

public class Multibrot {
	
	private int _array1[][] = new int [512][512];
	private double _x = 2.0/512;
	private double _y = 2.6/512;
	
	
	public Multibrot() {
		for (int i = 0; i < 511; i ++){
			 for (int j = 0; i < 511; i ++){
				 double xCalc = translateX(i);
				 double yCalc = translateY(j);
				 _array1[i][j] = EscapeTimeAlgorithm(xCalc, yCalc);
	}

		}
	}
	public double translateX(int i){
		 double xCalc = -1 + _x * i;
		 return xCalc;
	}
		 
		 public double translateY(int j){
			 double yCalc = -1.3 + _y * j;
			return yCalc;
		 }
		 public int EscapeTimeAlgorithm(double xCalc, double yCalc){
				int passes = 0;
				double dist = Math.sqrt((xCalc *xCalc) - (yCalc * yCalc));
				while (dist <= 2 && passes < 255){
					xCalc = ((xCalc * xCalc *xCalc) - (3 * xCalc * yCalc * yCalc));
					yCalc = ((3 * xCalc * xCalc * yCalc) - (yCalc * yCalc * yCalc));
					passes ++;
					dist = Math.sqrt(xCalc * xCalc + yCalc * yCalc);
				}
				return passes;
			}	 
	
}
