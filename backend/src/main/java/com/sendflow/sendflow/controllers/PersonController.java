package com.sendflow.sendflow.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sendflow.sendflow.entities.Person;
import com.sendflow.sendflow.entities.dto.PersonDto;
import com.sendflow.sendflow.entities.dto.PersonMinDto;
import com.sendflow.sendflow.entities.dto.WhatsAppDto;
import com.sendflow.sendflow.repositories.projecion.ICityDto;
import com.sendflow.sendflow.services.PersonService;
import com.sendflow.sendflow.services.SmsService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping(path = "/paginacao")
	public ResponseEntity<Page<Person>> findAllPaginacao(Pageable pageable) {
		return ResponseEntity.ok().body(service.findAllPaginacao(pageable));
	}

	@GetMapping(path = "/count")
	public ResponseEntity<Long> findCount() {
		return ResponseEntity.ok().body(service.findCount());
	}

	@GetMapping(path = "/city")
	public ResponseEntity<List<Person>> findTown(@RequestParam String town) {
		return ResponseEntity.ok().body(service.findTown(town));
	}

	// select cidade, count(*) from tb_pessoas where trim(cidade) not in('') group
	// by cidade having count(*) > 1 order by cidade;
	@GetMapping(path = "/selectcity")
	public ResponseEntity<List<ICityDto>> findCity() {
		return ResponseEntity.ok().body(service.findCity());
	}

	@PostMapping(value = "/states/{uf}")
	public ResponseEntity<Page<PersonDto>> findPersonUF(@PathVariable String uf, Pageable pageable) {
		return ResponseEntity.ok().body(service.findPersonUF(uf, pageable));
	}
	
	@GetMapping(value = "/limit")
	public ResponseEntity<List<PersonDto>> findPersonLimit() {
		return ResponseEntity.ok().body(service.findPersonLimit());
	}

	@PostMapping
	public ResponseEntity<PersonMinDto> insert(@RequestBody Person person) {
		PersonMinDto result = service.insert(person);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
		return ResponseEntity.created(uri).body(result);
	}

	// ###############################SMS
	@Autowired
	private SmsService smsService;

	@GetMapping("/exemplo")
	public void notifySmsExemplo() {
		smsService.exemplo();
	}
	
	@GetMapping("/{personId}/notification")
	public void notifySms(@PathVariable Long personId) {
		smsService.sendSms(personId);
	}

	@GetMapping("/whatsapp")
	public ResponseEntity<WhatsAppDto> notifyWhatsapp(@RequestParam Long personId, @RequestParam String strMsg) {

		WhatsAppDto dto = smsService.sendSms(personId, strMsg);
		return ResponseEntity.ok().body(dto);

	}
}
