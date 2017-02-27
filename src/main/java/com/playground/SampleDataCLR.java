package com.playground;

import java.util.Random;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class SampleDataCLR implements CommandLineRunner {

	private final PersonRepository personRepository;
	
	public SampleDataCLR(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	@Override
	public void run(String... arg0) throws Exception {
//		Stream.of("Stephine maldini", "Arjen Poutsma", "Josh long", "Rossen Stoyanchev", "Sebastin Deleuse"
//				).forEach(name ->
//				this.personRepository.save(new Person(name, new Random().nextInt(100)))
//				);
		this.personRepository.findAll().forEach(System.out::println);
	}

}
