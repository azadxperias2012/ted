package com.azadxperias.ted.repository;

import com.azadxperias.ted.model.TedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TedEventRepository extends JpaRepository<TedEvent, Integer> {
}
