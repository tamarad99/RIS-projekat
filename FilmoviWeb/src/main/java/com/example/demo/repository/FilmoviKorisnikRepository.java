package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Filmovikorisnik;

@Repository
@Transactional
public interface FilmoviKorisnikRepository extends JpaRepository<Filmovikorisnik, Integer>{

	Filmovikorisnik findByKorisnickoime(String korisnickoime);
}
