package com.example.desafio.tecnico.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.tecnico.entity.User;
import com.example.desafio.tecnico.repository.UserRepository;
import com.example.desafio.tecnico.service.UserService;

@Service
public class DefaultUserService implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(final Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User save(final User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(final Long id) {
		userRepository.deleteById(id);
	}

}
