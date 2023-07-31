package com;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeTest {
	
	@Test	
	public void passwordEncode() {
		System.out.println(new BCryptPasswordEncoder().encode("balaji1218"));
	}

}
