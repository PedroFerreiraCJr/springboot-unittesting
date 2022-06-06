package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.data.SomeDataService;

class SomeBusinessMockTest {

	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);

	@BeforeEach
	public void before() {
		business.setSomeDataService(dataServiceMock);
	}

	@Test
	public void calculateSumUsingDataService_basic() {
		// cenário
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });

		// ação
		// verificação
		assertEquals(6, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_emptyArray() {
		// cenário
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});

		// ação
		// verificação
		assertEquals(0, business.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		// cenário
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 10 });

		// ação
		// verificação
		assertEquals(10, business.calculateSumUsingDataService());
	}
}
