package com.example.demo.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import model.Film;
import model.Glumac;

public class UlogaImage implements Serializable{

	private static final long serialVersionUID = 1L;
	private int iduloga;
	private String naziv;
	private Glumac glumac;
	private Film film;
	private String ime;
	private String prezime;
	private MultipartFile slika;
	private int godina;
	private String nazivFilma;
	
	
	public String getNazivFilma() {
		return nazivFilma;
	}



	public void setNazivFilma(String nazivFilma) {
		this.nazivFilma = nazivFilma;
	}



	public int getGodina() {
		return godina;
	}



	public void setGodina(int godina) {
		this.godina = godina;
	}



	public UlogaImage() {}

	
	
	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public Film getFilm() {
		return film;
	}



	public void setFilm(Film film) {
		this.film = film;
	}



	public int getIduloga() {
		return iduloga;
	}

	public void setIduloga(int iduloga) {
		this.iduloga = iduloga;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Glumac getGlumac() {
		return glumac;
	}

	public void setGlumac(Glumac glumac) {
		this.glumac = glumac;
	}

	public MultipartFile getSlika() {
		return slika;
	}

	public void setSlika(MultipartFile slika) {
		this.slika = slika;
	}

	
	
}
