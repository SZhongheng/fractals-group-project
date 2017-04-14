package edu.buffalo.cse116;



public class Fractals {
	
	private double _startingXRange;
	private double _endingXRange;
	private double _startingYRange;
	private double _endingYRange;
	private int[][] fractalArray;

	public void setRanges(double startingXRange, double endingXRange, double startingYRange, double endingYRange) {
		_startingXRange = startingXRange;
		_endingXRange = endingXRange;
		_startingYRange = startingYRange;
		_endingYRange = endingYRange;
	}
	
	public double evenXDivision() {
		return (this._endingXRange - this._startingXRange) / 512;
	}
	
	public double evenYDivision() {
		return (this._endingYRange - this._startingYRange) / 512;
	}
	
	public double translateX(double index) {
		return this._startingXRange + (index * this.evenXDivision());
	}
	
	public double translateY(double index) {
		return this._startingYRange + (index * this.evenYDivision());
	}
	
	public int BurningShip(double xInput, double yInput, double escapeDistanceInput, double escapeTimeInput){
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		int passes = 0;
		while(dist <= escapeDistanceInput && passes < escapeTimeInput){
			newX = ((Math.pow(xCalc, 2)) - (Math.pow(yCalc, 2)) + xInput);
			newY = Math.abs(2*xCalc*yCalc) + yInput;
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public int Julia(double xInput, double yInput){
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		int passes = 0;
		while (dist <= 2 && passes < 255){
			newX = Math.pow((xCalc - 0), 2) - Math.pow((yCalc - 0), 2) + -0.72689;
			newY = (2 * xCalc * yCalc) + 0.188887;
			xCalc = newX;
			yCalc = newY;
			passes ++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public int Mandelbrot(double xInput, double yInput) {
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		int passes = 0;
		while (dist <= 2 && passes < 255) {
			newX = ((Math.pow(xCalc, 2)) - (Math.pow(yCalc, 2)) + xInput);
			newY = ((2 * xCalc * yCalc) + yInput);
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public int Multibrot(double xInput, double yInput){
		int passes = 0;
		double xCalc = xInput;
		double yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		while (dist <= 2 && passes < 255){
			newX = (Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2)) + xInput);
			newY = ((3 * Math.pow(xCalc, 2) * yCalc) - (Math.pow(yCalc, 3)) + yInput);
			xCalc = newX;
			yCalc = newY;
			passes ++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	
	public void createFractals(int choice, /*double sX, double eX, double sY, double eY,*/ double EDinput, double ETinput) {
		int row = 512;
		int col = 512;
		fractalArray = new int[row][col];
		
		if (choice == 1) {
			//this.setRanges(sX, eX, sY, eY);
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.BurningShip(this.translateX(i), this.translateY(j), EDinput, ETinput);
				}
			}
		}
		
		if (choice == 2) {
			//this.setRanges(sX, eX, sY, eY);
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.Julia(this.translateX(i), this.translateY(j));
				}
			}
		}
		
		if (choice == 3) {
			//this.setRanges(sX, eX, sY, eY);
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.Mandelbrot(this.translateX(i), this.translateY(j));
				}
			}
		}
		
		if (choice == 4) {
			//this.setRanges(sX, eX, sY, eY);
			for (int i = 0; i < fractalArray.length; i++) {
				for (int j = 0; j < fractalArray[0].length; j++) {
					fractalArray[i][j] = this.Multibrot(this.translateX(i), this.translateY(j));
				}
			}
		}
	}
	
	public int[][] getArray() {
		return this.fractalArray;
	}
}

