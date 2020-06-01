package com.test.ig;
import static org.junit.Assert.*;
import com.learn.ig.Number;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumberTest {
	Number obj=null;
	Boolean expected,actual;
	
	@Before
	public void setup() {
		obj = new Number();
		
	}
	
	@Test
	public void testPrimality() {
		expected = true;
		actual = obj.checkPrime(5);
		assertEquals(expected, actual);
	}

	@Test
	public void testArmstrong() {	
		expected = true;
		actual = obj.checkArmstrong(370);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testPalindrome() {
		expected = true;
		actual = obj.checkPalindrome(525);
		assertEquals(expected, actual);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nonFucntionalTest() {
		 obj.checkArmstrong(52);
	}
	
	@After
	public void tearDown() {
		obj=null;
	}
	
}
