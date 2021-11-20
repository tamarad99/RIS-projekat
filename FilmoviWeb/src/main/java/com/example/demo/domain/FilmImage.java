package com.example.demo.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import model.Kategorija;
import model.Ocena;
import model.Zanr;

public class FilmImage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idfilma;
	private String reziser;
	private String naziv;
	private String opis;
	private Integer trajanje;
	private Ocena ocena;
	private Zanr zanr;
	private Kategorija kategorija;
	private MultipartFile slika;
	
	public FilmImage() {
	}
	
	

	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public Integer getTrajanje() {
		return trajanje;
	}



	public void setTrajanje(Integer trajanje) {
		this.trajanje = trajanje;
	}



	public int getIdfilma() {
		return idfilma;
	}

	public void setIdfilma(int idfilma) {
		this.idfilma = idfilma;
	}

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Ocena getOcena() {
		return ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public MultipartFile getSlika() {
		return slika;
	}

	public void setSlika(MultipartFile slika) {
		this.slika = slika;
	}
}