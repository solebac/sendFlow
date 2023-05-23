package com.sendflow.sendflow.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_pessoas")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@NotNull
	@Size(min = 1, max = 15)
	@Column(unique=true)
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
	
	public Person(Long id, String nome, String cpf, String cep, String cidade, String uf, String ramal00,
			String telefone00, String ramal01, String telefone01, String ramal02, String telefone02) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.ramal00 = ramal00;
		this.telefone00 = telefone00;
		this.ramal01 = ramal01;
		this.telefone01 = telefone01;
		this.ramal02 = ramal02;
		this.telefone02 = telefone02;
	}
	public Person() {
		super();
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
