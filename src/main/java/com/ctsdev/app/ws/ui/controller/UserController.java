package com.ctsdev.app.ws.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctsdev.app.ws.entity.User;
import com.ctsdev.app.ws.service.UserService;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {
	
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUser() {
		
		return this.userService.fetchAllUser();
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome!";
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user){
		this.userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User has been created");
	}
	
	@PutMapping("/{username}")
	public ResponseEntity<String> updateUser(@PathVariable String username, @RequestBody User user) {
		this.userService.updateUser(username,user);
		return ResponseEntity.status(HttpStatus.OK).body("User has been updated");
	}
	
	@DeleteMapping("/{username}")
	public String deleteUser(@PathVariable String username) {
		this.userService.deleteUser(username);
		return "User has been deleted";
	}
	
	

}
