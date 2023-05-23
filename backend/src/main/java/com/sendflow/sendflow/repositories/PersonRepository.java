package com.sendflow.sendflow.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sendflow.sendflow.entities.Person;
import com.sendflow.sendflow.entities.dto.PersonDto;
import com.sendflow.sendflow.repositories.projecion.ICityDto;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	@Query("SELECT obj FROM Person obj")
	List<PersonDto> findPersonLimit(Pageable pageable);
	
	@Query("SELECT obj FROM Person obj WHERE obj.uf = :state ORDER BY obj.id DESC")
	Page<PersonDto> findPersonUF(String state, Pageable pageable);
	
	@Query("SELECT count(*) FROM Person")
	long countRegister();
	
	//Page<Person> findByCidade(String cidade, Pageable pageable);
	List<Person> findByCidade(String cidade);
	
	@Query(value = "select cidade, count(*) as contador  "
			+ "from tb_pessoas where trim(cidade) not in('') "
			+ "group by cidade having count(*) > 1 order by cidade;", nativeQuery = true)
	List<ICityDto> findDistinctCidade();
	
}