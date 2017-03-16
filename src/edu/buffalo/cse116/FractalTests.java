package edu.buffalo.cse116;
import static org.junit.Assert.*;

import org.junit.Test;


//d
public class FractalTests {
	Fractal F = new Fractal();
	@Test
	public void bsNeverExceed(){
		assertEquals(255, F.bsETA(-1.7443359374999874,-0.017451171875000338), 0.0001);
	}
	@Test 
	public void bsTranslateX(){
		assertEquals(-1.7,F.bsTranslateX(512), .0001);
	}
	@Test
	public void bsTranslateY(){
		assertEquals(0.025,F.bsTranslateY(512),.0001);
	}
	
	@Test
	public void bsFractal(){
		assertEquals(262144,F.bsArray().length*F.bsArray()[0].length);
	}
	@Test
	public void testJuliaNeverExceed(){
		assertEquals(255, F.jETA(1.0492187499999897, -0.234375), 0.000001);
	}
	@Test
	public void testJuliaExceed(){
		assertEquals(1, F.jETA(1.6933593749999853, 0.9765625), 0.0000001);
	}
	@Test
	public void JxTranslate(){
		assertEquals(1.7, F.jTranslateX(512), 0.001);
	}
	@Test
	public void JyTranslate(){
		assertEquals(1.0, F.jTranslateY(512),0.001);
	}
	
	@Test
	public void JgetArray() {
		assertEquals(262144, F.jArray().length * F.jArray()[0].length);
	}
	@Test
	public void MAtest_translateX() {
		assertEquals(-2.15, F.maTranslateX(0), 0.01);
		assertEquals(0.6, F.maTranslateX(511), 0.01);
	}
	
	@Test
	public void MAtest_translateY() {
		assertEquals(-1.3, F.maTranslateY(0), 0.01);
		assertEquals(1.3, F.maTranslateY(511), 0.01);
	}
	
	@Test
	public void MAtest_escapeTimeNeverExceeds() {
		assertEquals(255, F.maETA(0.3207031250000001, -0.07109374999999386), 0.00000000001);
	}
	
	@Test
	public void MAtest_escapeTimeExceeds() {
		assertEquals(1, F.maETA(0.5946289062500001, 1.2949218750000122), 0.00000000001);
	}
	
	@Test
	public void MAtest_getArray() {
		assertEquals(262144, F.maArray().length * F.maArray()[0].length);
	}
	@Test
	public void testMultibrotNeverExceed(){
		assertEquals(255, F.muETA(0.5859375, 0.24375000000000108), 0.0001);
		
	}
	@Test
	public void testMultibrotExceed(){
		assertEquals(1, F.muETA(0.9921875, 1.05625 ));
	}
	@Test
	public void MUxTranslate(){
		assertEquals(1.0, F.muTranslateX(512), 0.00001);
	}
	@Test
	public void MUyTranslate(){
		assertEquals(1.3, F.muTranslateY(512), 0.001);
	}
	
	@Test
	public void MUtest_getArray() {
		assertEquals(262144, F.muArray().length * F.muArray()[0].length);
	}
}
