package com.firas.DojoAndNinjas.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firas.DojoAndNinjas.models.Dojo;
import com.firas.DojoAndNinjas.models.Ninja;
import com.firas.DojoAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	// === CRUD ===

	@Autowired
	private DojoRepository Repo;

	// READ ALL
	public List<Dojo> allDojos() {
		return Repo.findAll();
	}

	// CREATE
	public Dojo createDojo(Dojo d) {
		return Repo.save(d);
	}

	// READ ONE
	public Dojo findDojo(Long id) {

		Optional<Dojo> dojo = Repo.findById(id);
		if (dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}
    public List<Ninja> findAllNinjasInDojo(Long dojoId) {
        Optional<Dojo> dojoOptional = Repo.findById(dojoId);
        if (dojoOptional.isPresent()) {
            Dojo dojo = dojoOptional.get();
            return dojo.getNinjas();
        }
        return Collections.emptyList(); 
    }

	// UPDATE
	public Dojo updateDojo(Dojo d) {
		return Repo.save(d);
	}

	// DELETE
	public void deleteDojo(Long id) {
		Repo.deleteById(id);
	}

}
