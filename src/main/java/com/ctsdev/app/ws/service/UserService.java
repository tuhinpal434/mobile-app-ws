package com.ctsdev.app.ws.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctsdev.app.ws.entity.User;
import com.ctsdev.app.ws.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> fetchAllUser() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userRepository.save(user);
		
	}

	public void updateUser(String username, User user) {
		// TODO Auto-generated method stub
		User foundUser = null;
		Optional<User> found = this.userRepository.findById(username);
		if(found.isPresent()) {
			foundUser = found.get();
			foundUser.setFirstname(user.getFirstname());
			foundUser.setLastname(user.getLastname());
			foundUser.setPhoneNumber(user.getPhoneNumber());
		}
		this.userRepository.save(foundUser);
		
	}

	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
		this.userRepository.deleteById(username);
		
	}

}
