package com.example.mysite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.mysite.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmailAndPassword(String email, String password);
	
	
//	@Modifying
//	@Query( "update User u set u.name=:name where u.no=:no" )
//	int update(@Param("name") String name, @Param("no") Long no );

	@Modifying
	@Query( "update User u set u.name=:#{#user.name }, u.email=#{#user.email }, u.gender=#{#user.gender } where u.no=:#{#user.no }" )
	int update( @Param("user") User user );

}
