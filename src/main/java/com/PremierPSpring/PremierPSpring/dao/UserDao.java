package com.PremierPSpring.PremierPSpring.dao;

import com.PremierPSpring.PremierPSpring.POjO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Integer> {
   User findByEmailId(@Param("email") String email);
}
