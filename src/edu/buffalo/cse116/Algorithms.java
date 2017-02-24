package edu.buffalo.cse116;
public class Algorithms {
	protected double xCalc;
	protected double xTemp;
	protected double NyCalc;
	protected double yCalc;
	protected double dist;
	protected int passes;
	protected int escapeTime;
	protected int row = 512;
	protected int col = 512;
	
	public void MandelbrotSet() {
		int[][] MandelbrotSetArray = new int[row][col];
		for (int i = 0; i < MandelbrotSetArray.length; i ++) {
			for (int j = 0; j < MandelbrotSetArray[0].length; j++) {
			}
		}
		xCalc = 0.3207031250000001;
		yCalc = -0.07109374999999386;
		dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		passes = 0;
		while (dist <= 2 && passes < 255) {
			xTemp = (Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + xCalc);
			yCalc = (2 * xCalc * yCalc + yCalc);
			xCalc = xTemp;
			passes++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		escapeTime = passes;
	}
	
	public double MandelbrotSetDist(double dist) {
		double finalDist = dist;
		return finalDist;
	}
	
	public int MandelbrotSetEscapeTime(int escapeTime) {
		int finalEscapeTime = escapeTime;
		return finalEscapeTime;
	}
}
