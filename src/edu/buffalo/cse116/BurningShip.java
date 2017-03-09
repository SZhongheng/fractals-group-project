package edu.buffalo.cse116;

import java.util.Arrays;

public class BurningShip {
	
	private double xCalc;
	private double yCalc;
	private int[][] FractalArray = new int[512][512];
	
	/**
	 * Translate a pixel's row to the associated x-coordinate in the fractal
	 * @return the x-coordinate in the fractal
	 */
	public double translateX(int j) {
		double x = 0.1/512;
		return -1.8 + x * j;	
	}
	
	/**
	 * Translate a pixel's row to the associated y-coordinate in the fractal
	 * @return the y-coordinate in the fractal
	 */
	public double translateY(int i) {
		double y = 0.105/512;
		return -0.08 + y * i;
	}
	
	/**
	 * Escape Time algorithm for the fractal
	 * @return the escape time
	 */
	public int ETABurningShip(double xInput, double yInput){
		xCalc = xInput;
		yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		int passes = 0;
		while(dist <= 2 && passes<255){
			newX = ((xCalc*xCalc) - (yCalc*yCalc) + xInput);
			newY = Math.abs(2*xCalc*yCalc) + yInput;
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		}
		return passes;
	
	}
	
	/**Creates a 2d array which the fractal image will be created*/
	public BurningShip(){
		for(int i = 0; i < FractalArray.length; i++){
			for(int j = 0; j<FractalArray[0].length; j++){
				
				FractalArray[i][j] = ETABurningShip(translateX(i), translateY(j));
			}
		}
	}
	
	public int[][] getArray(){
		return this.FractalArray;
	}
	
	public boolean zerorone(){
		boolean x = true;
		for(int i = 0;i<512;i++){
			for(int j = 0;j<512;j++){
				if (FractalArray[i][j] == 1 || FractalArray[i][j] == 0){
					x = false;
				}
			}
		}
		return x;
	}
}
	
	
	
	
		
		

