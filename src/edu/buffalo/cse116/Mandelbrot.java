package edu.buffalo.cse116;

import org.junit.experimental.theories.Theories;

public class Mandelbrot {
	
	private double startingXRange = -2.15;
	private double endingXRange = 0.6;
	private double startingYRange = -1.3;
	private double endingYRange = 1.3;
	private double evenXDivision = (this.endingXRange - this.startingXRange) / 511;
	private double evenYDivision = (this.endingYRange - this.startingYRange) / 511;
	private int passes;
	private int escapeTime;
	private int row = 512;
	private int col = 512;
	private int[][] MandelbrotArray = new int[row][col];
	private double X;
	private double Y;
	
	public double translateX(double index) {
		return this.startingXRange + (index * this.evenXDivision);
	}
	
	public double translateY(double index) {
		return this.startingYRange + (index * this.evenYDivision);
	}
	
	public int escapeTime(double xInput, double yInput) {
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		int i;
		int j;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		passes = 0;
		while (dist <= 2 && passes < 255) {
			newX = ((Math.pow(xCalc, 2)) - (Math.pow(yCalc, 2)) + xInput);
			newY = ((2 * xCalc * yCalc) + yInput);
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
			escapeTime = passes;
		}
		return escapeTime;
	}
	
	public void setArray() {
		for (int i = 0; i < this.MandelbrotArray.length; i++) {
			for (int j = 0; j < this.MandelbrotArray[0].length; j++) {
				this.MandelbrotArray[i][j] = this.escapeTime(X, Y);
			}
		}
	}
	
	public int[][] getArray() {
		return this.MandelbrotArray;
	}
}
