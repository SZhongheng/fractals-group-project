package edu.buffalo.cse116;

public class BurningShip {
	private double dist;
	private int passes;
	private int escapetime;	
	double x = .0001953;
	double y = .000205;
	/*
	 * Set xCalc = current point's x-coordinate
      Set yCalc = current point's y-coordinate
      Set dist = distance from the point (xCalc, yCalc) to (0,0) using the Pythagorean theorem
      Set passes = 0
      While dist ≤ 2 and passes < 255 do
        Update xCalc and yCalc using the update function defined for the fractal being generated
        Increase passes by 1
        Set dist = distance from the point (xCalc, yCalc) to (0,0) using the Pythagorean theorem
      EndWhile
      Set the current point's escape-time equal to passes
	 */
	public int BurningShipFractal(double xCalc, double yCalc){
		dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		passes = 0;
		while(dist <= 2 && passes<255){
			xCalc = ((xCalc*xCalc) - (yCalc*yCalc) + xCalc);
			yCalc = Math.abs(2*xCalc*yCalc) + yCalc;
			passes++;
			dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		}
		escapetime = passes;
		return escapetime;
	}
	public int[][] BurningShipArray(int rows, int cols){
		rows = 512;
		cols = 512; 
		int [][] x = new int[rows][cols];
		return x;	
	}
	public double BurningShipX(double index){
		index = ((x * index) + x) ;
		return index;
		}
	public double BurningShipY(double index){
		index = ((y*index) + y);
		return index;
	}
		
	}
	
	
	
	
		
		

