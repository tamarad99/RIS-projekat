package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Film;
import model.Zanr;
@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{

	List<Film> findFilmByZanr(Zanr zanr);
	
	Film findFilmByNaziv(String naziv);
	
	@Query("SELECT f From Film f WHERE f.ocena.ocena BETWEEN :min and :max order by f.ocena.ocena")
	public List<Film> getFilmoviIzmedju(@Param("min") Integer min, @Param("max") Integer max);
	
	public List<Film> findFirst10ByOrderByOcenaOcenaDesc();
}