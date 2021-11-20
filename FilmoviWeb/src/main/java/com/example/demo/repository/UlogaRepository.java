package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Film;
import model.Uloga;

public interface UlogaRepository extends JpaRepository<Uloga, Integer>{

	List<Uloga> findUlogaByFilm(Film film);
}
