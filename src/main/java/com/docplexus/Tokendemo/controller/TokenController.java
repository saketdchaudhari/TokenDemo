package com.docplexus.Tokendemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docplexus.Tokendemo.bean.Token;
import com.docplexus.Tokendemo.service.TokenService;

@RestController
@RequestMapping(value = { "/token" })
public class TokenController {

	@Autowired
	TokenService tokenService;

//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Token> getUserById(@PathVariable("id") int id) {
//		System.out.println("Fetching User with id " + id);
//		Token token = tokenService.findById(id);
//		if (token == null) {
//			return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Token>(token, HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/create", headers = "Accept=application/json")
//	public ResponseEntity<Integer> createUser(@RequestBody Customer customer) {
//		System.out.println("Creating Token for " + customer.getName());
////		Integer token = tokenService.createToken(customer);
//		return null;
//	}
//
//	@DeleteMapping(value = "/{id}", headers = "Accept=application/json")
//	public ResponseEntity<Token> deleteUser(@PathVariable("id") int id) {
//		Token token = tokenService.findById(id);
//		if (token == null) {
//			return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
//		}
//		tokenService.deleteUserById(id);
//		return new ResponseEntity<Token>(HttpStatus.NO_CONTENT);
//	}
//	
	@GetMapping(value = "/generate/{userId}", produces = "application/json")
	public ResponseEntity<Token> generateToken(@PathVariable("userId") long userId) {
		Token token = tokenService.createToken(userId);
		if (token == null) {
			return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Token>(token, HttpStatus.CREATED);
	}

	@GetMapping(value = "/next/{counterId}", produces = "application/json")
	public ResponseEntity<Token> nextByPriority(@PathVariable("counterId") int counterId) {
		System.out.println("Assigning Token for counter- " + counterId);
		Token token = tokenService.nextByPriority(counterId);
		// display token with counter no by socket programming.

		return new ResponseEntity<Token>(token, HttpStatus.OK);
	}
}
