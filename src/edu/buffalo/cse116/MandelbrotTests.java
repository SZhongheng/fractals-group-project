package edu.buffalo.cse116;
import static org.junit.Assert.*;

import org.junit.Test;

public class MandelbrotTests {
	Mandelbrot M = new Mandelbrot();
	
	@Test
	public void test_translateX() {
		assertEquals(-2.15, M.translateX(0), 0.00000000001);
		assertEquals(0.6, M.translateX(511), 0.00000000001);
	}
	
	@Test
	public void test_translateY() {
		assertEquals(-1.3, M.translateY(0), 0.0000000001);
		assertEquals(1.3, M.translateY(511), 0.00000000001);
	}
	
	@Test
	public void test_escapeTime() {
		assertEquals(255, M.escapeTime(0.3207031250000001, -0.07109374999999386));
	}
	
	@Test
	public void test_escapeTimeSingleLoop() {
		assertEquals(1, M.escapeTime(0.5946289062500001, 1.2949218750000122));
	}
	
	@Test
	public void test_getArray() {
		assertEquals(262144, M.getArray().length * M.getArray()[0].length);
	}
}
