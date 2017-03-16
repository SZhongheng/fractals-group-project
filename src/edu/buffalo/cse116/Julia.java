package edu.buffalo.cse116;
    
public class Julia{
//d	
	private int _array1[][] = new int [512][512];
	
	private double _x = 3.4/512;
	private double _y = 2.0/512;
	/*
	Creates a 2d array which the fractal image will be created
	
	 */
	public Julia(){
	 for (int i = 0; i < _array1.length; i ++){
		 for (int j = 0;j < _array1[0].length; j ++){
			
			 _array1[i][j] = EscapeTimeAlgorithm(translateX(i), translateY(j));
		 }
	 }
		 
			 
		 }
	/*
	 * translate a pixel's row to the associated x-coordinate in the fractal
	 * @return the x-coordinate in the fractal
	 */
	 public double translateX(int i){
		 double xCalc = -1.7 + _x * i;
		 return xCalc;
		 //haha
	 }
	 /*
		 * translate a pixel's row to the associated y-coordinate in the fractal
		 * @return the y-coordinate in the fractal
		 */
	 public double translateY(int j){
		 double yCalc = -1.0 + _y * j;
		return yCalc;
	 }
		
	
	 /*
		 * Escape Time algorithm for the fractal
		 * @return the escape time
		 */
	public int EscapeTimeAlgorithm(double xInput, double yInput){
		int escapeTime = 0;
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(xCalc * xCalc + (yCalc * yCalc));
		int passes = 0;
		while (dist <= 2 && passes < 255){
			newX = (xCalc * xCalc) - (yCalc * yCalc) + -0.72689;
			newY = (2 * xCalc * yCalc) + 0.188887;
			xCalc = newX;
			yCalc = newY;
			passes ++;
			dist = Math.sqrt(xCalc * xCalc + yCalc * yCalc);
			escapeTime = passes;
		}
		return escapeTime;
	}				 
			 
			
	public int[][] getArray() {
		return this._array1;
	}	
		
}
