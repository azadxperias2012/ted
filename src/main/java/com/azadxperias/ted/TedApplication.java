package com.azadxperias.ted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TedApplication {

	public static void main(String[] args) {
		SpringApplication.run(TedApplication.class, args);
	}
}

//public class TedApplication {
//
//	public static void main(String[] args) {
//		System.out.println("Covert to date");
//
//		String date = "1151367060";
//		System.out.println(new Date(Long.valueOf(date) * 1000L));
//
//	}
//}
