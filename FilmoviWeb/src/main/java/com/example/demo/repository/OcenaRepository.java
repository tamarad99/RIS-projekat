package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Film;
import model.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Integer>{

	Ocena findByOcena(Integer ocena);

}
