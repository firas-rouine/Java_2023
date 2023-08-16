package com.firas.BookClub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.firas.BookClub.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	// FIND USER BY EMAIL
    Optional<User> findByEmail(String email);

}
