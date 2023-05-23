package com.sendflow.sendflow.entities.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sendflow.sendflow.entities.Person;

public class PersonDto {
	private Long id;
	private String nome;
	private String cpf;
	private String cep;
	private String cidade;
	private String uf;
	private String ramal00;
	private String telefone00;
	private String ramal01;
	private String telefone01;
	private String ramal02;
	private String telefone02;
	public PersonDto() {
		super();
	}
	
	public PersonDto(Person obj) {
		id = obj.getId();
		nome = obj.getNome();
		cpf = obj.getCpf();
		cep = obj.getCep();
		cidade = obj.getCidade();
		uf = obj.getUf();
		ramal00 = obj.getRamal00();
		telefone00 = obj.getTelefone00();
		ramal01 = obj.getRamal01();
		telefone01 = obj.getTelefone01();
		ramal02 = obj.getRamal02();
		telefone02 = obj.getTelefone02();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getRamal00() {
		return ramal00;
	}
	public void setRamal00(String ramal00) {
		this.ramal00 = ramal00;
	}
	public String getTelefone00() {
		return telefone00;
	}
	public void setTelefone00(String telefone00) {
		this.telefone00 = telefone00;
	}
	public String getRamal01() {
		return ramal01;
	}
	public void setRamal01(String ramal01) {
		this.ramal01 = ramal01;
	}
	public String getTelefone01() {
		return telefone01;
	}
	public void setTelefone01(String telefone01) {
		this.telefone01 = telefone01;
	}
	public String getRamal02() {
		return ramal02;
	}
	public void setRamal02(String ramal02) {
		this.ramal02 = ramal02;
	}
	public String getTelefone02() {
		return telefone02;
	}
	public void setTelefone02(String telefone02) {
		this.telefone02 = telefone02;
	}

}
