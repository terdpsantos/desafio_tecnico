package com.example.desafio.tecnico.service;

import java.util.List;

import com.example.desafio.tecnico.entity.User;

public interface UserService {

	/**
	 * @see Returns the list of registered users
	 * @return {@link List}
	 */
	List<User> getAll();

	User getById(final Long id);

	/**
	 * @see Save informed user
	 * @param user
	 * @return {@link User}
	 */
	User save(final User user);

	/**
	 * @see Delete informed user
	 * @param id
	 */
	void delete(final Long id);
}
