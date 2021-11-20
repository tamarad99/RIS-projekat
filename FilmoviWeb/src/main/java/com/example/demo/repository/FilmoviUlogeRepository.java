package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Filmoviuloga;

@Repository
public interface FilmoviUlogeRepository extends JpaRepository<Filmoviuloga, Integer>{

}