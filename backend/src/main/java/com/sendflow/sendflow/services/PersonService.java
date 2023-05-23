package com.sendflow.sendflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sendflow.sendflow.entities.Person;
import com.sendflow.sendflow.entities.dto.PersonDto;
import com.sendflow.sendflow.entities.dto.PersonMinDto;
import com.sendflow.sendflow.repositories.PersonRepository;
import com.sendflow.sendflow.repositories.projecion.ICityDto;
import com.sendflow.sendflow.services.exceptions.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;

	@Transactional(readOnly = true)
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Person> findAllPaginacao(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Transactional(readOnly = true) //Afins de test
	public Page<PersonDto> findPersonUF(String uf, Pageable pageable) {
		return repository.findPersonUF(uf, pageable);
	}
	
	@Transactional(readOnly = true)
	public List<PersonDto> findPersonLimit() {
		Pageable pageable = PageRequest.of(0,5);
		return repository.findPersonLimit(pageable);
	}

	@Transactional(readOnly = true)
	public Person findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Not Found!"));
	}

	@Transactional(readOnly = true)
	public List<Person> findTown(String cidade) {
		return repository.findByCidade(cidade);
	}
	
	@Transactional(readOnly = true)
	public List<ICityDto> findCity() {
		return repository.findDistinctCidade();
	}

	public long findCount() {
		return repository.countRegister();
	}

	@Transactional
	public PersonMinDto insert(Person obj) {

		try {
			Person person = repository.save(obj);
			return new PersonMinDto(person);
		} catch (DataIntegrityViolationException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}
}
