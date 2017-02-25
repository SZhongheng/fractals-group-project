package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class BurningShipTests {

	BurningShip ship = new BurningShip();
	@Test
	public void NoExceedEscapedistance() {
		assertEquals(2, ship.ETABurningShip(-1.7443359374999874,-0.017451171875000338), 0.0001);

	}
	@Test 
	public void translateX(){
		assertEquals(-1.7,ship.translateX(512), .0001);
	}
	@Test
	public void translateY(){
		assertEquals(0.025,ship.translateY(512),.0001);
	}
	@Test
	public void noZEROorONE(){
		
		
		}
		
		
	
	@Test
	public void FractalArray(){
		assertEquals(262144,ship.BurningShipFractal(512,512).length*ship.BurningShipFractal(512, 512).length);
	}
	
}
