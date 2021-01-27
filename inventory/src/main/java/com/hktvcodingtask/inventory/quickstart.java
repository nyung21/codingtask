package com.hktvcodingtask.inventory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class quickstart {
    @RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}
