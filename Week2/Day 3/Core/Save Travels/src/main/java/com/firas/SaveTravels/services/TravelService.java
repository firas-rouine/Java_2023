package com.firas.SaveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firas.SaveTravels.models.Travel;
import com.firas.SaveTravels.repositories.TravelRepository;

@Service
public class TravelService {
	// === CRUD ===

	@Autowired
	private TravelRepository Repo;

	// READ ALL
	public List<Travel> allTravels() {
		return Repo.findAll();
	}

	// CREATE
	public Travel createTravel(Travel b) {
		return Repo.save(b);
	}

	// READ ONE
	public Travel findTravel(Long id) {

		Optional<Travel> maybeTravel = Repo.findById(id);
		if (maybeTravel.isPresent()) {
			return maybeTravel.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Travel updateTravel(Travel b) {
		return Repo.save(b);
	}

	// DELETE
	public void deleteTravel(Long id) {
		Repo.deleteById(id);
	}

}
