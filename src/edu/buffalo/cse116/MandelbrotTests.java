package edu.buffalo.cse116;
import static org.junit.Assert.*;

import org.junit.Test;

public class MandelbrotTests {
	Mandelbrot A = new Mandelbrot();
	
	@Test
	public void test_MandelbrotSetDist() {
		A.MandelbrotSet();
		assertEquals(0, A.MandelbrotSetDist(A.dist), 0.0001);
	}
	
	@Test
	public void test_MandelbrotSetEscapeTime() {
		A.MandelbrotSet();
		assertEquals(0, A.MandelbrotSetEscapeTime(A.escapeTime));
	}
}
