package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;
//d
public class JuliaTest {
	
	Julia j = new Julia();
	
	
	@Test
	public void testJuliaNeverExceed(){
		assertEquals(255, j.EscapeTimeAlgorithm(1.0492187499999897, -0.234375), 0.000001);
	}
	@Test
	public void testJuliaExceed(){
		assertEquals(1, j.EscapeTimeAlgorithm(1.6933593749999853, 0.9765625), 0.0000001);
	}
	@Test
	public void xTranslate(){
		assertEquals(1.7, j.translateX(512), 0.001);
	}
	@Test
	public void yTranslate(){
		assertEquals(1.0, j.translateY(512),0.001);
	}
	
	@Test
	public void getArray() {
		assertEquals(262144, j.getArray().length * j.getArray()[0].length);
	}

}
