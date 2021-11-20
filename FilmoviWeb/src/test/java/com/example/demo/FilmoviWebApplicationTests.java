package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EntityScan("model")
class FilmoviWebApplicationTests {

	@Test
	void contextLoads() {
	}

}
