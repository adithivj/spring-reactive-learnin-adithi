package com.playground;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;





public interface PersonRepository extends MongoRepository<Person, String> {
	
	@Query("{}")
Stream<Person> all();
	
	CompletableFuture<Person> findById(String id);
}
