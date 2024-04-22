package com.example.desafio.tecnico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.tecnico.dto.UserDTO;
import com.example.desafio.tecnico.facade.UserFacade;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserFacade userFacade;

	@GetMapping
	public String getVersion() {	
		return "Version 1.0";
	}

	@GetMapping("/list")
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<>(userFacade.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(userFacade.getUserById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
		try {
			return new ResponseEntity<>(userFacade.save(userDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
		try {
			return new ResponseEntity<>(userFacade.update(userDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(userFacade.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}