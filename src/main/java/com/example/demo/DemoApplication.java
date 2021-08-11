package com.example.demo;

import com.example.demo.entity.ThemeParkRide;
import com.example.demo.repository.ThemeParkRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner SampleData(ThemeParkRespository respository){

		return (args -> {

			respository.save(new ThemeParkRide("RollerCoaster","Train ride that speeds you along",5,3));
			respository.save(new ThemeParkRide("Log Flume","Boat ride with plenty of splashes",3,2));
			respository.save(new ThemeParkRide("Tearcups","Spinning ride in a giant tea-cup",2,4));

		});
	}
}
