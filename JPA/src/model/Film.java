package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idfilm")
	private int idfilm;

	private String naziv;

	private String opis;
	
	private String reziser;
	
	@Lob
	@Column(name="slika")
	private byte[] slika;

	public byte[] getSlika() {
		return slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	private int trajanje;


	//bi-directional many-to-one association to Kategorija
	@ManyToOne
	private Kategorija kategorija;

	//bi-directional many-to-one association to Ocena
	@ManyToOne
	private Ocena ocena;

	//bi-directional many-to-one association to Zanr
	@ManyToOne
	private Zanr zanr;

	//bi-directional many-to-one association to Uloga
	@OneToMany(mappedBy="film")
	private List<Uloga> ulogas;

	public Film() {
	}

	public int getIdfilm() {
		return this.idfilm;
	}

	public void setIdfilm(int idfilm) {
		this.idfilm = idfilm;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public Kategorija getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public Ocena getOcena() {
		return this.ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}

	public Zanr getZanr() {
		return this.zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public List<Uloga> getUlogas() {
		return this.ulogas;
	}

	public void setUlogas(List<Uloga> ulogas) {
		this.ulogas = ulogas;
	}

	public Uloga addUloga(Uloga uloga) {
		getUlogas().add(uloga);
		uloga.setFilm(this);

		return uloga;
	}

	public Uloga removeUloga(Uloga uloga) {
		getUlogas().remove(uloga);
		uloga.setFilm(null);

		return uloga;
	}

}