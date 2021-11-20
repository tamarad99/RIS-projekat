package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategorija database table.
 * 
 */
@Entity
@Table(name="kategorija")
@NamedQuery(name="Kategorija.findAll", query="SELECT k FROM Kategorija k")
public class Kategorija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkategorija;

	private String naziv;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="kategorija")
	private List<Film> films;

	public Kategorija() {
	}

	public int getIdkategorija() {
		return this.idkategorija;
	}

	public void setIdkategorija(int idkategorija) {
		this.idkategorija = idkategorija;
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
		film.setKategorija(this);

		return film;
	}

	public Film removeFilm(Film film) {
		getFilms().remove(film);
		film.setKategorija(null);

		return film;
	}

}