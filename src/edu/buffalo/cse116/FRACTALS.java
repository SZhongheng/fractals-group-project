package edu.buffalo.cse116;
public class FRACTALS {
	private double _startingXRange;
	private double _endingXRange;
	private double _startingYRange;
	private double _endingYRange;
	private int[][] fractalArray;
	private int constant = 512;
	private int _choice;
	private double _escapeDistance;
	private int _escapeTime;
	
	public void setRanges(double startingXRange, double endingXRange, double startingYRange, double endingYRange) {
		_startingXRange = startingXRange;
		_endingXRange = endingXRange;
		_startingYRange = startingYRange;
		_endingYRange = endingYRange;
	}
	
	public double evenXDivision() {
		return (this._endingXRange - this._startingXRange) / constant;
	}
	
	public double evenYDivision() {
		return (this._endingYRange - this._startingYRange) / constant;
	}
	
	public double translateX(double index) {
		return this._startingXRange + (index * this.evenXDivision());
	}
	
	public double translateY(double index) {
		return this._startingYRange + (index * this.evenYDivision());
	}
	
	public int BurningShip(double xInput, double yInput, double escapeDistance, double escapeTime){
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		int passes = 0;
		while(dist <= escapeDistance && passes < escapeTime){
			newX = ((Math.pow(xCalc, 2)) - (Math.pow(yCalc, 2)) + xInput);
			newY = Math.abs(2*xCalc*yCalc) + yInput;
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public int Julia(double xInput, double yInput, double escapeDistance, double escapeTime){
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		int passes = 0;
		while (dist <= escapeDistance && passes < escapeTime){
			newX = Math.pow((xCalc - 0), 2) - Math.pow((yCalc - 0), 2) + -0.72689;
			newY = (2 * xCalc * yCalc) + 0.188887;
			xCalc = newX;
			yCalc = newY;
			passes ++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public int Mandelbrot(double xInput, double yInput, double escapeDistance, double escapeTime) {
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		int passes = 0;
		while (dist <= escapeDistance && passes < escapeTime) {
			newX = ((Math.pow(xCalc, 2)) - (Math.pow(yCalc, 2)) + xInput);
			newY = ((2 * xCalc * yCalc) + yInput);
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public int Multibrot(double xInput, double yInput, double escapeDistance, double escapeTime){
		int passes = 0;
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		while (dist <= escapeDistance && passes < escapeTime){
			newX = (Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2)) + xInput);
			newY = ((3 * Math.pow(xCalc, 2) * yCalc) - (Math.pow(yCalc, 3)) + yInput);
			xCalc = newX;
			yCalc = newY;
			passes ++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public void setChoice(int choice) {
		_choice = choice;
	}
	
	public int getChoice() {
		return _choice;
	}
	
	public void setEscapeDistance(double escapeDistance) {
		_escapeDistance = escapeDistance;
	}
	
	public double getescapeDistance() {
		return _escapeDistance;
	}
	
	public void setEscapeTime(int escapeTime) {
		_escapeTime = escapeTime;
	}
	
	public int getEscapeTime() {
		return _escapeTime;
	}
	
	public void createFractals(double escapeDistance, double escapeTime) {
		int row = constant;
		int col = constant;
		fractalArray = new int[row][col];
		
		if (this.getChoice() == 1) {
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.BurningShip(this.translateX(i), this.translateY(j), escapeDistance, escapeTime);
				}
			}
		}
		
		if (this.getChoice() == 2) {
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.Julia(this.translateX(i), this.translateY(j), escapeDistance, escapeTime);
				}
			}
		}
		
		if (this.getChoice() == 3) {
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.Mandelbrot(this.translateX(i), this.translateY(j), escapeDistance, escapeTime);
				}
			}
		}
		
		if (this.getChoice() == 4) {
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.Multibrot(this.translateX(i), this.translateY(j), escapeDistance, escapeTime);
				}
			}
		}
	}
	
	public int[][] getArray() {
		return this.fractalArray;
	}
}
