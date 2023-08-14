package com.firas.DojoAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firas.DojoAndNinjas.models.Ninja;
import com.firas.DojoAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// === CRUD ===

	@Autowired
	private NinjaRepository Repo;

	// READ ALL
	public List<Ninja> allNinjas() {
		return Repo.findAll();
	}

	// CREATE
	public Ninja createNinja(Ninja n) {
		return Repo.save(n);
	}

	// READ ONE
	public Ninja findNinja(Long id) {

		Optional<Ninja> ninja = Repo.findById(id);
		if (ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Ninja updateNinja(Ninja n) {
		return Repo.save(n);
	}

	// DELETE
	public void deleteNinja(Long id) {
		Repo.deleteById(id);
	}

}
