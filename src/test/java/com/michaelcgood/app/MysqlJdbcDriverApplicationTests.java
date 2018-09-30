package com.michaelcgood.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = {"org.hibernate"})
@SpringBootTest
public class MysqlJdbcDriverApplicationTests {

	@Test
	public void contextLoads() {

	}

}
