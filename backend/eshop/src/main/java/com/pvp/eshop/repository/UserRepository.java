package com.pvp.eshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pvp.eshop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}