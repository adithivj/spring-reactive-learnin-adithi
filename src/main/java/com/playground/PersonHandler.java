package com.playground;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.Request;
import org.springframework.web.reactive.function.Response;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {

	private final PersonRepository personRepository;

	public PersonHandler(PersonRepository personRepository) {

		this.personRepository = personRepository;
	}

	Response<Flux<Person>> all(Request request) {
		
		Flux<Person> flux =  Flux.fromStream(this.personRepository.all());
		//Flux<Person> flux =  Flux.fromIterable(this.personRepository.all());
		return Response.ok().body(BodyInserters.fromPublisher(flux, Person.class));
		
	}

	Response<Mono<Person>> byId(Request request) {
	Optional<String> optional = request.pathVariable("id");
	return optional.map(id -> this.personRepository.findById(id))
			.map(person -> Mono.fromFuture(person))
			.map(mono -> Response.ok().body( BodyInserters.fromPublisher(mono, Person.class)))
		
			.orElseThrow(() -> new IllegalStateException("Oops"));
	}

}
