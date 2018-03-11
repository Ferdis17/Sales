package com.allSales.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.allSales.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	@Query(value = "SELECT r FROM Role r WHERE r.role = :role")
	Role findRoleByRoleName(@Param("role") String role);

}
