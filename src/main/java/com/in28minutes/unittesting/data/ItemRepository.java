package com.in28minutes.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
