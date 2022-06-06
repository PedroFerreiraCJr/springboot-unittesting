package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.data.SomeDataService;

class SomeBusinessMockTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		// cenário
		SomeBusinessImpl business = new SomeBusinessImpl();

		// cria e configura o objeto mock
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		business.setSomeDataService(dataServiceMock);

		// ação
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 6;

		// verificação
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_emptyArray() {
		// cenário
		SomeBusinessImpl business = new SomeBusinessImpl();

		// cria e configura o objeto mock
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		business.setSomeDataService(dataServiceMock);

		// ação
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;

		// verificação
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {
		// cenário
		SomeBusinessImpl business = new SomeBusinessImpl();

		// cria e configura o objeto mock
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 10 });
		business.setSomeDataService(dataServiceMock);

		// ação
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 10;

		// verificação
		assertEquals(expectedResult, actualResult);
	}
}
