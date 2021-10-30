package com.ctsdev.app.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctsdev.app.ws.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
