package com.in28minutes.unittesting.business;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.model.Item;

/**
 * Como estou usando a versão do JUnit 5, é preciso utilizar a anotação abaixo
 * ao invés da @RunWith(MockitoJUnitRunner.class), que deve ser usada quando
 * utilizando outro runner no JUnit 4.
 */
@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService itemBusinessService;

	@Mock
	private ItemRepository repository;

	@Test
	public void retrieveAllItems_basic() {
		Mockito.when(repository.findAll())
				.thenReturn(Arrays.asList(new Item(2, "Item 2", 10, 10), new Item(3, "Item 3", 20, 20)));

		List<Item> allItems = itemBusinessService.retrieveAllItems();

		Assertions.assertEquals(allItems.size(), 2);
		Assertions.assertEquals(allItems.get(0).getValue(), 100);
		Assertions.assertEquals(allItems.get(0).getValue(), 400);
	}

	@Test
	public void retrieveAllItems_emptyList() {
		Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());

		List<Item> allItems = itemBusinessService.retrieveAllItems();

		Assertions.assertNotNull(allItems.size());
		Assertions.assertEquals(allItems.size(), 0);
	}
}
