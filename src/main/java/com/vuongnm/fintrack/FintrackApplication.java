package com.vuongnm.fintrack;

import com.vuongnm.fintrack.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FintrackApplication {

	public static void main(String[] args) {
//		SpringApplication.run(FintrackApplication.class, args);

		ApplicationContext context = SpringApplication.run(FintrackApplication.class, args);
//		UserRepository userRepository = context.getBean(UserRepository.class);

		ExportLogRepository transactionRepository = context.getBean(ExportLogRepository.class);
		transactionRepository.findAll().forEach(System.out::println);
//		userRepository.findAll().forEach(System.out::println);
	}

}
