package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class BurningShipTests {

	BurningShip ship = new BurningShip();
	@Test
	public void NoExceedEscapedistance() {
		assertEquals(2, ship.BurningShipFractal(-1.7443359374999874,-0.017451171875000338), 0.0001);
	}
	@Test
	public void ArraySize(){
		assertEquals(262144,ship.BurningShipArray(512,512).length*ship.BurningShipArray(512,512).length);
	}
	@Test 
	public void translateX(){
		assertEquals(.1001,ship.BurningShipX(512), .0001);
	}
	@Test
	public void translateY(){
		assertEquals(.000205,ship.BurningShipY(0),.0001);
	}
	
	
}
