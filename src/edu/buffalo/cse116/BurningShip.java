package edu.buffalo.cse116;

public class BurningShip {
	
	private double xCalc;
	private double yCalc;
	private int[][] FractalArray = new int[512][512];
	
	/*
	Creates a 2d array which the fractal image will be created
	 */
	public int[][] BurningShipFractal(int x, int y){
		for(int i = 0; i < FractalArray.length; i++){
			for(int j = 0; j<FractalArray[0].length; j++){
				xCalc = translateX(i);
				yCalc = translateY(j);
				FractalArray[i][j] = ETABurningShip(xCalc, yCalc);
			}
			
		}
		return FractalArray;
	}
	/*
	 * translate a pixel's row to the associated x-coordinate in the fractal
	 * @return the x-coordinate in the fractal
	 */
	public double translateX(int j) {
		double x = 0.1/512;
		return -1.8 + x * j;	
	}
	/*
	 * translate a pixel's row to the associated y-coordinate in the fractal
	 * @return the y-coordinate in the fractal
	 */
	public double translateY(int i) {
		double y = 0.105/512;
		return -0.08 + y * i;
	}
	/*
	 * Escape Time algorithm for the fractal
	 * @return the escape time
	 */
	public int ETABurningShip(double xCalc, double yCalc){
		double dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		int passes = 0;
		while(dist <= 2 && passes<255){
			xCalc = ((xCalc*xCalc) - (yCalc*yCalc) + xCalc);
			yCalc = Math.abs(2*xCalc*yCalc) + yCalc;
			passes++;
			dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		}
		return passes;
	
	}
	
}
	
	
	
	
		
		

