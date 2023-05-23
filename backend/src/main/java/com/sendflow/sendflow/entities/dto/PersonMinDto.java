package com.sendflow.sendflow.entities.dto;

import com.sendflow.sendflow.entities.Person;

public class PersonMinDto {
	private Long id;

	public PersonMinDto(Person person) {
		id = person.getId();
	}

	public Long getId() {
		return id;
	}
}
