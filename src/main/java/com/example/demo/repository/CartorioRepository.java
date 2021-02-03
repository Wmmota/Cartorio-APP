package com.example.demo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long>{
	List<Cartorio> findByName(String name);
}
