package com.in28minutes.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.model.Item;

/**
 * Esta classe testa a camanda Controller da arquitetura em três camadas:
 * Controller layer, Business layer, Data layer.
 * 
 * link de tutorial em como testar a serialização de JSON:
 * https://rieckpil.de/testing-your-json-serialization-with-jsontest/
 */
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	/**
	 * <pre>
	 * &#64;WebMvcTest é a anotação que torna possível o uso da classe MockMvc no
	 * contexto do teste.
	 * </pre>
	 */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * <pre>
	 * &#64;MockBean é uma anotação do Spring Boot usada para criar bean mocados.
	 * </pre>
	 */
	@MockBean
	private ItemBusinessService businessService;

	/**
	 * O objetivo deste teste é fazer uma chamada para a URI /dummy-item que está
	 * presente no controller ItemController.
	 * 
	 * @throws Exception
	 */
	@Test
	public void dummyItem_basic() throws Exception {
		// constrói a requisição que será feita
		// @formatter:off
		RequestBuilder request = MockMvcRequestBuilders
			.get("/dummy-item")
			.accept(MediaType.APPLICATION_JSON);
		// @formatter:on

		// executa a requisição criada anteriormente e pega a resposta
		// @formatter:off
		MvcResult result = mockMvc.perform(request)
			.andExpect(status().isOk())
			// o método json, mesmo quando ausente um atributo do JSON, o teste passa com barra verde
			// pode ser que isso não seja o esperado, na maioria dos casos
			.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
			.andReturn();
		// @formatter:on

		// verifica o resultado da resposta
//		Assertions.assertEquals("Hello World", result.getResponse().getContentAsString());
	}

	/**
	 * <pre>
	 * O objetivo deste teste é fazer uma chamada para a URI
	 * <strong>/item-from-business-service</strong> que está presente no controlador
	 * ItemController.
	 * 
	 * Mas a questão que deve ser notada é que, agora, temos uma dependência, e portanto,
	 * como este é um teste unitário da camada de controlador, será preciso mocar a camada
	 * de serviço que é utilizada na invocação do método itemFromBusinessService()
	 * da classe ItemController.
	 * </pre>
	 * 
	 * @throws Exception
	 */
	@Test
	public void itemBusinessService_basic() throws Exception {
		// @formatter:off
		Mockito.when(businessService.retrieveHardcodedItem())
			.thenReturn(new Item(2, "Item 2", 10, 10));

		RequestBuilder request = MockMvcRequestBuilders
			.get("/item-from-business-service")
			.accept(MediaType.APPLICATION_JSON);
		// @formatter:on

		// @formatter:off
		MvcResult result = mockMvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().json("{id:2, name:\"Item 2\", price:10}"))
			.andReturn();
		// @formatter:on
	}
}
