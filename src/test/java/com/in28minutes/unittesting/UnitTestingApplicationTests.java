package com.in28minutes.unittesting;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = { "classpath:test-configuration.properties" })
class UnitTestingApplicationTests {

	@Test
	void contextLoads() {
	}
}
