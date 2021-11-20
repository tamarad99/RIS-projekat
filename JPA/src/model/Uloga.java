package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uloga database table.
 * 
 */
@Entity
@Table(name="uloga")
@NamedQuery(name="Uloga.findAll", query="SELECT u FROM Uloga u")
public class Uloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduloga;

	private String naziv;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="film_idfilm")
	private Film film;

	//bi-directional many-to-one association to Glumac
	@ManyToOne
	private Glumac glumac;

	public Uloga() {
	}

	public int getIduloga() {
		return this.iduloga;
	}

	public void setIduloga(int iduloga) {
		this.iduloga = iduloga;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Glumac getGlumac() {
		return this.glumac;
	}

	public void setGlumac(Glumac glumac) {
		this.glumac = glumac;
	}

}