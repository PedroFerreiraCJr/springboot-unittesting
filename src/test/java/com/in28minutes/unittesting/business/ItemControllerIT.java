package com.in28minutes.unittesting.business;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * Esta anotação inicializa o contexto da aplicação por completo. Além disso,
 * configura um banco de dados em memória. Se houver dados para serem inseridos
 * através do script data.sql, ele também será executado.
 * 
 * O metadado informado (webEnvironment), faz com que a parte web da aplicação
 * rode em uma porta aleatória.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	private static final boolean MODO_NAO_RESTRITO = false;

	/**
	 * Esta classe já obtém automaticamente a porta que foi escolhida aleatoriamente
	 * no momento da inicialização do contexto da aplicação.
	 */
	@Autowired
	private TestRestTemplate restTemplate;

	/**
	 * Este teste faz uma requisição para o endpoint "/all-items-from-database", e
	 * verifica o resultado no formato String através da classe JSONAssert.
	 */
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/all-items-from-database", String.class);

		JSONAssert.assertEquals("[{id: 10001}, {id: 10002}, {id: 10003}]", response, MODO_NAO_RESTRITO);
	}
}
