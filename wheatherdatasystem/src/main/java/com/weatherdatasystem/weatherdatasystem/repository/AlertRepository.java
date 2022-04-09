package com.weatherdatasystem.weatherdatasystem.repository;

import com.weatherdatasystem.weatherdatasystem.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert,Integer> {
}
