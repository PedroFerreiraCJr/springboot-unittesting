package com.in28minutes.unittesting.spike;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		final String responseFromService = "["
				+ "	{ \"id\": 10000, \"name\": \"Pencil\", \"quantity\": 5 },"
				+ "	{ \"id\": 10001, \"name\": \"Pen\", \"quantity\": 15 },"
				+ "	{ \"id\": 10002, \"name\": \"Eraser\", \"quantity\": 10 }"
				+ "]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		Assertions.assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		Assertions.assertThat(ids).containsExactly(10_000, 10_001, 10_002);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:2]").toString());
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
	}
}
