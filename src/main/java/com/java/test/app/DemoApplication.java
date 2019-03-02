package com.java.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*
@ComponentScan({
	"com.java.test.app.services.impl.CustomerServiceImpl",
	"com.java.test.app.dao.impl.UserDaoImpl"
})*/
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
