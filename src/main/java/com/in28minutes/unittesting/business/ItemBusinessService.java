package com.in28minutes.unittesting.business;

import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.model.Item;

@Component
public class ItemBusinessService {

	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}
}
