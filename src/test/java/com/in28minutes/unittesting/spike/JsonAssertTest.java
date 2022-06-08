package com.in28minutes.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	/**
	 * Em ambos os casos espaços em branco de formatação são aceitos.
	 */
	private static final boolean MODO_ESTRITO = true;
	private static final boolean MODO_NAO_ESTRITO = false;

	/**
	 * Exemplo de resposta retornada pelo serviço rest
	 */
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		/**
		 * <pre>
		 * Considera tanto valores do atributos quanto os elementos retornados.
		 * 
		 * O primeiro argumento é o resultado esperado;
		 * O segundo argumento é o resultado que vem da execução da ação;
		 * O terceiro argumento é o modo de comparação dos argumentos
		 *  anteriores, sendo eles: estrito (true), ou não estrito (false);
		 * 
		 * No modo estrito, quando há atributos ausentes, por exemplo, o
		 *  teste não passa. Ou seja, a estrutura do JSON deve ser iqual.
		 * </pre>
		 */
		JSONAssert.assertEquals(expectedResponse, actualResponse, MODO_ESTRITO);
	}

	@Test
	public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponseWithoutQuantityAtribute = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		/**
		 * <pre>
		 * Considera somente os valores em cada atributo JSON. Mesmo que falte
		 * algum atributo, se não houver valores diferentes do esperado, o teste passa.
		 * 
		 * O primeiro argumento é o resultado esperado;
		 * O segundo argumento é o resultado que vem da execução da ação;
		 * O terceiro argumento é o modo de comparação dos argumentos
		 *  anteriores, sendo eles: estrito (true), ou não estrito (false);
		 * 
		 * No modo estrito, quando há atributos ausentes, por exemplo, o
		 *  teste não passa. Ou seja, a estrutura do JSON deve ser iqual.
		 * </pre>
		 */
		JSONAssert.assertEquals(expectedResponseWithoutQuantityAtribute, actualResponse, MODO_NAO_ESTRITO);
	}

	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponseWithoutEscapeCharacters = "{id:1, name:Ball, price:10}";
		/**
		 * <pre>
		 * Considera somente os valores em cada atributo JSON. Mesmo que falte
		 * algum atributo, se não houver valores diferentes do esperado, o teste passa.
		 * O JSONAssert também aceita valores JSON sem caracteres de Escape (aspas duplas, por exemplo).
		 * Quando houver espaços entre valores, é necessário colocar as aspas duplas para definir que o valor
		 * é uma string composta.
		 * 
		 * O primeiro argumento é o resultado esperado;
		 * O segundo argumento é o resultado que vem da execução da ação;
		 * O terceiro argumento é o modo de comparação dos argumentos
		 *  anteriores, sendo eles: estrito (true), ou não estrito (false);
		 * 
		 * No modo estrito, quando há atributos ausentes, por exemplo, o
		 *  teste não passa. Ou seja, a estrutura do JSON deve ser iqual.
		 * </pre>
		 */
		JSONAssert.assertEquals(expectedResponseWithoutEscapeCharacters, actualResponse, MODO_NAO_ESTRITO);
	}
}
