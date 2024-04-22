package com.example.desafio.tecnico.facade;

import java.util.List;

import com.example.desafio.tecnico.dto.UserDTO;

public interface UserFacade {

	/**
	 * @see Returns the list of registered users
	 * @return {@link UserDTO}
	 */
	List<UserDTO> getAllUsers();

	/**
	 * @see Returns the user informed using id
	 * @param id
	 * @return {@link UserDTO}
	 */
	UserDTO getUserById(final Long id);

	/**
	 * @see Save informed user
	 * @param userDTO
	 * @return {@link UserDTO}
	 */
	UserDTO save(final UserDTO userDTO);

	/**
	 * @see Update informed user
	 * @param userDTO
	 * @return {@link UserDTO}
	 */
	UserDTO update(final UserDTO userDTO);

	/**
	 * @see Delete informed user
	 * @param id
	 * @return {@link String}
	 */
	String delete(final Long id);

}
