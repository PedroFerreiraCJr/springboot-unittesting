package com.in28minutes.unittesting.controller;

import org.junit.jupiter.api.Assertions;
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
 */
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * O objetivo deste teste é fazer uma chamada para a URI /hello-world que está
	 * presente no controller HelloWorldController.
	 * 
	 * @throws Exception
	 */
	@Test
	public void helloWorld_basic() throws Exception {
		// constrói a requisição que será feita
		// @formatter:off
		RequestBuilder request = MockMvcRequestBuilders
			.get("/hello-world")
			.accept(MediaType.APPLICATION_JSON);
		// @formatter:on

		// executa a requisição criada anteriormente e pega a resposta
		MvcResult result = mockMvc.perform(request).andReturn();

		// verifica o resultado da resposta
		Assertions.assertEquals("Hello World", result.getResponse().getContentAsString());
	}
}
