package com.in28minutes.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Esta classe testa a camanda Controller da arquitetura em três camadas:
 * Controller layer, Business layer, Data layer.
 * 
 * link de tutorial em como testar a serialização de JSON:
 * https://rieckpil.de/testing-your-json-serialization-with-jsontest/
 */
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

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
			.andExpect(content().json("{\"id\":1,\"name\":\"\",\"price\":10,\"quantity\":100}"))
			.andReturn();
		// @formatter:on

		// verifica o resultado da resposta
//		Assertions.assertEquals("Hello World", result.getResponse().getContentAsString());
	}
}
