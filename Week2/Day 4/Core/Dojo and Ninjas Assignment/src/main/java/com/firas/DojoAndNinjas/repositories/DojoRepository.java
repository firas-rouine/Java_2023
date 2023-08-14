package com.firas.DojoAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.firas.DojoAndNinjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List <Dojo> findAll();

}
