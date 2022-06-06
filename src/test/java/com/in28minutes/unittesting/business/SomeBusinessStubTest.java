package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.data.SomeDataService;

/**
 * Exemplo de classe Stub para servir como uma implementação que acesso o banco
 * de dados e retornar os valores necessário para a classe SomeBusinessImpl.
 */
class SomeDataServiceStub implements SomeDataService {

	private int[] data;

	public SomeDataServiceStub setData(int[] data) {
		this.data = data;
		return this;
	}

	@Override
	public int[] retrieveAllData() {
		return this.data;
	}
}

class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		// cenário
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub().setData(new int[] { 1, 2, 3 }));

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
		business.setSomeDataService(new SomeDataServiceStub().setData(new int[] {}));

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
		business.setSomeDataService(new SomeDataServiceStub().setData(new int[] { 10 }));

		// ação
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 10;

		// verificação
		assertEquals(expectedResult, actualResult);
	}
}
