package com.example.demo.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Employee23,Integer> {
	Employee23 findByName(String name);
}
