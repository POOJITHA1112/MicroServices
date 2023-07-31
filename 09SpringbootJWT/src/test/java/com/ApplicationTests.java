package com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void passwordEncoder() {
		System.out.println(new BCryptPasswordEncoder().encode("Poojitha@1618"));
	}

}