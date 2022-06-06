package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.data.SomeDataService;

/**
 * Como estou usando a versão do JUnit 5, nesta aula é preciso utilizar a
 * anotação abaixo ao invés da @RunWith(MockitoJUnitRunner.class), que deve ser
 * usada quando utilizando outro runner no JUnit 4.
 */
@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {

	@InjectMocks	// Esta anotação cria a instância deste objeto, e injeta os mocks declarados neste teste
	SomeBusinessImpl business;

	@Mock			// Esta anotação declara que esse atributo é um mock a ser injetado no objeto de teste
	SomeDataService dataServiceMock;

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
