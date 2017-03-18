package edu.buffalo.cse116;

public class Fractal {
	private double xCalc;
	private double yCalc;
	private int[][] bsFractal = new int[512][512];
	private int[][] jFractal = new int[512][512];
	private int[][] maFractal = new int[512][512];
	private int[][] muFractal = new int[512][512];
	private double newX;
	private double newY;
	private double x;
	private double y;
	private int numInput;
	public double bsTranslateX(int i){
		 x = 0.1/512;
		 return -1.8 + x * i;	
	}
	public double bsTranslateY(int j){
		y = .105/512;
		return -0.08 + y * j;
	}
	public double jTranslateX(int i){
		x=3.4/512;
		return -1.7 + x * i;
	}
	public double jTranslateY(int j){
		y = 2.0/512;//d
		return -1.0 + y * j;
	}
	public double maTranslateX(int i){
		x = 2.75/512;
		return -2.15 + x * i;
	}
	public double maTranslateY(int j){
		y = 2.6/512;
		return -1.3 + y * j;
	}
	public double muTranslateX(int i){
		x = 2.0/512;
		return -1.0 + x * i;
	}
	public double muTranslateY(int j){
		y = 2.6/512;
		return -1.3 + y * j;
	}
	public int bsETA(double xInput, double yInput, double numInput){
		xCalc = xInput;
		yCalc = yInput;
		double newX;
		double newY;
		double dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		int passes = 0;
		while(dist <= numInput && passes<255){
			newX = ((xCalc*xCalc) - (yCalc*yCalc) + xInput);
			newY = Math.abs(2*xCalc*yCalc) + yInput;
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		}
		return passes;
	}
	public int jETA(double xInput, double yInput, double numInput){
		xCalc = xInput;
		yCalc = yInput;
		double dist = Math.sqrt(xCalc * xCalc + (yCalc * yCalc));
		int passes = 0;
		while (dist <= numInput && passes < 255){
			newX = (xCalc * xCalc) - (yCalc * yCalc) + -0.72689;
			newY = (2 * xCalc * yCalc) + 0.188887;
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt(xCalc * xCalc + yCalc * yCalc);
		}
		return passes;
	}
	
	public int maETA(double xInput, double yInput, double numInput){
		xCalc = xInput;
		yCalc = yInput;
		double dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		int passes = 0;
		while (dist <= numInput && passes < 255) {
			newX = ((Math.pow(xCalc, 2)) - (Math.pow(yCalc, 2)) + xInput);
			newY = ((2 * xCalc * yCalc) + yInput);
			xCalc = newX;
			yCalc = newY;
			passes++;
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow((yCalc - 0), 2));
		}
		return passes;
	}
	public int muETA(double xInput, double yInput, double numInput){
		xCalc = xInput;
		yCalc = yInput;
		double dist = Math.sqrt((xCalc*xCalc)+(yCalc*yCalc));
		int passes = 0;
		while (dist <= numInput && passes < 255){
			newX = ((xCalc * xCalc *xCalc) - (3 * xCalc * yCalc * yCalc)+xInput);
			newY = ((3 * xCalc * xCalc * yCalc) - (yCalc * yCalc * yCalc)+yInput);
			xCalc = newX;
			yCalc = newY;
			passes ++;
			dist = Math.sqrt(xCalc * xCalc + yCalc * yCalc);
		}
		return passes;
	}
	public int[][] bsArray(double numInput){
		for(int i = 0; i < bsFractal.length; i++){
			for(int j = 0; j<bsFractal[0].length; j++){
				bsFractal[i][j] = bsETA(bsTranslateX(i), bsTranslateY(j), numInput);
				}
			}
		return this.bsFractal;
		}
	public int[][] jArray(double numInput){
		for(int i = 0; i < jFractal.length; i++){
			for(int j = 0; j<jFractal[0].length; j++){
				jFractal[i][j] = jETA(jTranslateX(i),jTranslateY(j) , numInput);
				}
			}
		return this.jFractal;
		}
	public int[][] maArray(double numInput){
		for(int i = 0; i < maFractal.length; i++){
			for(int j = 0; j<maFractal[0].length; j++){
				double x = maTranslateX(i);
				double y = maTranslateY(j);
				maFractal[i][j] = maETA(x, y, numInput);
				}
			}
		return this.maFractal;
		}
	public int[][] muArray(double numInput){
		for(int i = 0; i < muFractal.length; i++){
			for(int j = 0; j<muFractal[0].length; j++){
				muFractal[i][j] = muETA(muTranslateX(i), muTranslateY(j), numInput);
				}
			}
		return this.muFractal;
		}
	public int[][]getbsArray(){
		return this.bsFractal;
	}
	public boolean zerorone(){
		boolean x = true;
		for(int i = 0;i<bsFractal.length;i++){
			for(int j = 0;j<bsFractal[0].length;j++){
				if (bsFractal[i][j] == 1 || bsFractal[i][j] == 0){
					x = false;
				}
			}
		}
		return x;
	}
	
}



