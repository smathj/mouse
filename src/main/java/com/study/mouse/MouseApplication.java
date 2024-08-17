package com.study.mouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MouseApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(MouseApplication.class, args);
		} catch(Exception e) {
		    e.printStackTrace();
		}
	}

}
