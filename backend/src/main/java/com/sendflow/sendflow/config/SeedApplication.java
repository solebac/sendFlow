package com.sendflow.sendflow.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sendflow.sendflow.entities.Person;
import com.sendflow.sendflow.repositories.PersonRepository;

@Configuration
@Profile("test")
public class SeedApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Person p1 = new Person(null, "Flavio Rogerio", "12345678900", "38180000", "Araxá", "MG", "34", "36621074", "34", "987214500", "34", "987214577");
		Person p2 = new Person(null, "Lucas Rogerio", "15545678900", "38180000", "Araxá", "MG", "34", "36621000", "34", "988814500", "34", "986714577");
		
		repository.saveAll(Arrays.asList(p1,p2));
			
		
	}

}
