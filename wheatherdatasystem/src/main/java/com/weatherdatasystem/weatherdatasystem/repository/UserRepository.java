package com.weatherdatasystem.weatherdatasystem.repository;

import com.weatherdatasystem.weatherdatasystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
