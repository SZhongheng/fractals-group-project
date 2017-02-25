package edu.buffalo.cse116;


/*The fractals your program will be generating this term are all "escape-time algorithms". Escape-time algorithms imagine the picture is a Cartesian plane (I had to look this up, too -- it means point is defined by its x- and y-coordinates). Each PIXEL (point on this plane) is then colored using the following process:

    Set xCalc = current point's x-coordinate
    Set yCalc = current point's y-coordinate
    Set dist = distance from the point (xCalc, yCalc) to (0,0) using the Pythagorean theorem
    Set passes = 0
    While dist ≤ 2 and passes < 255 do
      Update xCalc and yCalc using the update function defined for the fractal being generated
      Increase passes by 1
      Set dist = distance from the point (xCalc, yCalc) to (0,0) using the Pythagorean theorem
    EndWhile
    Set the current point's escape-time equal to passes*/
    
public class Julia{
	
	private int _array1[][] = new int [512][512];
	
	private double _x = 3.4/512;
	private double _y = 2.0/512;
	/*
	Creates a 2d array which the fractal image will be created
	 */
	public Julia(){
	 for (int i = 0; i < 512; i ++){
		 for (int j = 0; i < 512; i ++){
			 double xCalc = translateX(i);
			 double yCalc = translateY(j);
			 _array1[i][j] = EscapeTimeAlgorithm(xCalc, yCalc);
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
	public int EscapeTimeAlgorithm(double xCalc, double yCalc){
		int passes = 0;
		double dist = Math.sqrt(xCalc * xCalc + (yCalc * yCalc));
		while (dist <= 2 && passes < 255){
			xCalc = (xCalc * xCalc) - (yCalc * yCalc) + -0.72689;
			yCalc = (2 * xCalc * yCalc) + 0.188887;
			passes ++;
			dist = Math.sqrt(xCalc * xCalc + yCalc * yCalc);
		}
		return passes;
	}
			
	public int[][] getArray() {
		return this._array1;
	}	
		
}
