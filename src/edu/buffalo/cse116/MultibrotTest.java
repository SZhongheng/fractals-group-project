package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultibrotTest {
	
	Multibrot m = new Multibrot();
	
	@Test
	public void testMultibrotNeverExceed(){
		assertEquals(255, m.EscapeTimeAlgorithm(0.5859375, 0.24375000000000108), 0.0001);
		
	}
	@Test
	public void testMultibrotExceed(){
		assertEquals(0, m.EscapeTimeAlgorithm(0.9921875, 1.05625 ));
	}
	@Test
	public void xTranslate(){
		assertEquals(1.0, m.translateX(512), 0.00001);
	}
	@Test
	public void yTranslate(){
		assertEquals(1.3, m.translateY(512), 0.001);
	}

}
