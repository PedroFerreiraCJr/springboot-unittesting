package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {

	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 1, 2, 3 });
		int expectedResult = 6;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSum_emptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult = 0;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSum_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 10 });
		int expectedResult = 10;

		assertEquals(expectedResult, actualResult);
	}
}
