package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zanr database table.
 * 
 */
@Entity
@Table(name="zanr")
@NamedQuery(name="Zanr.findAll", query="SELECT z FROM Zanr z")
public class Zanr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idzanr;

	private String naziv;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="zanr")
	private List<Film> films;

	public Zanr() {
	}

	public int getIdzanr() {
		return this.idzanr;
	}

	public void setIdzanr(int idzanr) {
		this.idzanr = idzanr;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Film> getFilms() {
		return this.films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Film addFilm(Film film) {
		getFilms().add(film);
		film.setZanr(this);

		return film;
	}

	public Film removeFilm(Film film) {
		getFilms().remove(film);
		film.setZanr(null);

		return film;
	}

}