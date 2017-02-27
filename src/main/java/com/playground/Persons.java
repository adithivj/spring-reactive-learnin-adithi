package com.playground;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
@Component
@XmlRootElement (name="persons")
public class Persons implements Serializable {
  
	Flux<Person> person ;

	public Flux<Person> getPerson() {
		return person;
	}

	public void setPerson(Flux<Person> person) {
		this.person = person;
	}
}
