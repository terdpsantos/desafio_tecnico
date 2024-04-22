package com.example.desafio.tecnico.facade.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.desafio.tecnico.config.Constants;
import com.example.desafio.tecnico.config.ModelMapperConfig;
import com.example.desafio.tecnico.dto.UserDTO;
import com.example.desafio.tecnico.entity.User;
import com.example.desafio.tecnico.facade.UserFacade;
import com.example.desafio.tecnico.service.UserService;

@Service
public class DefaultUserFacade implements UserFacade {

	@Autowired
	UserService userService;

	@Override
	public List<UserDTO> getAllUsers() {
		final List<User> usersList = userService.getAll();
		if (CollectionUtils.isEmpty(usersList)) {
			throw new RuntimeException(Constants.NO_USER);
		}
		return this.converterUser(usersList);
	}

	@Override
	public UserDTO getUserById(final Long id) {

		if (Objects.isNull(id)) {
			throw new RuntimeException(Constants.INVALID_PARAM);
		}

		final User user = userService.getById(id);
		if (Objects.isNull(user)) {
			throw new RuntimeException(Constants.NO_USER);
		}

		return converterUser(user);

	}

	@Override
	public UserDTO save(final UserDTO userDTO) {
		if (Objects.isNull(userDTO)) {
			throw new RuntimeException(Constants.INVALID_PARAM);
		}

		return converterUser(userService.save(ModelMapperConfig.modelMapper().map(userDTO, User.class)));
	}

	@Override
	public UserDTO update(final UserDTO userDTO) {
		if (Objects.isNull(userDTO)) {
			throw new RuntimeException(Constants.INVALID_PARAM);
		}

		final User user = userService.getById(userDTO.getId());
		if (Objects.isNull(user)) {
			throw new RuntimeException(Constants.NO_USER);
		}

		return converterUser(userService.save(ModelMapperConfig.modelMapper().map(userDTO, User.class)));
	}

	@Override
	public String delete(final Long id) {
		if (Objects.isNull(id)) {
			throw new RuntimeException(Constants.INVALID_PARAM);
		}
		userService.delete(id);
		return "Usuário excluído com sucesso!";
	}

	private List<UserDTO> converterUser(final List<User> users) {
		return users.stream().map(user -> ModelMapperConfig.modelMapper().map(user, UserDTO.class)).toList();
	}

	private UserDTO converterUser(final User user) {
		return ModelMapperConfig.modelMapper().map(user, UserDTO.class);
	}

}
