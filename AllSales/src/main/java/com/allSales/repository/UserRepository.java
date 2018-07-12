package com.allSales.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.allSales.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query(value = "SELECT u FROM User u WHERE u.email = :email")
    User findUsersByEmail(@Param("email") String email);

}
