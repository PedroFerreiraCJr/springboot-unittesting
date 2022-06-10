package com.in28minutes.unittesting.data;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.in28minutes.unittesting.model.Item;

/**
 * <pre>
 * Esta anotação configura o contexto do Spring com entidades, repositórios,
 * assim como o banco de dados em memória, e pode ser utilizada com qualquer
 * implementação da spec JPA.
 * 
 * Caso o arquivo data.sql esteja declarado na pasta
 * correta, ele também é executado.
 * </pre>
 */
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository repository;

	/**
	 * <pre>
	 * Conforme você deve saber, testar um método deste (findAll), é desnecessário.
	 * Mas caso tenha sido desenvolvido uma consulta que precise ser validada em
	 * ambiente de teste de maneira automatizada, criar um teste para ele é
	 * essencial.
	 * </pre>
	 */
	@Test
	public void findAll_basic() {
		List<Item> items = repository.findAll();
		Assertions.assertEquals(3, items.size());
	}

	/**
	 * <pre>
	 * Conforme você deve saber, testar um método deste (findById), é desnecessário.
	 * Mas caso tenha sido desenvolvido uma consulta que precise ser validada em
	 * ambiente de teste de maneira automatizada, criar um teste para ele é
	 * essencial.
	 * </pre>
	 */
	@Test
	public void findById_basic() {
		Optional<Item> opt = repository.findById(10001);
		Item item = opt.get();
		Assertions.assertEquals(10001, item.getId());
		Assertions.assertEquals("Item 1", item.getName());
	}
}
