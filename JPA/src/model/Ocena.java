package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ocena database table.
 * 
 */
@Entity
@Table(name="ocena")
@NamedQuery(name="Ocena.findAll", query="SELECT o FROM Ocena o")
public class Ocena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idocena;

	private String komentar;

	private int ocena;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="ocena")
	private List<Film> films;

	//bi-directional many-to-one association to Regostrovani
	@OneToMany(mappedBy="ocena")
	private List<Regostrovani> regostrovanis;

	public Ocena() {
	}

	public int getIdocena() {
		return this.idocena;
	}

	public void setIdocena(int idocena) {
		this.idocena = idocena;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public int getOcena() {
		return this.ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public List<Film> getFilms() {
		return this.films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Film addFilm(Film film) {
		getFilms().add(film);
		film.setOcena(this);

		return film;
	}

	public Film removeFilm(Film film) {
		getFilms().remove(film);
		film.setOcena(null);

		return film;
	}

	public List<Regostrovani> getRegostrovanis() {
		return this.regostrovanis;
	}

	public void setRegostrovanis(List<Regostrovani> regostrovanis) {
		this.regostrovanis = regostrovanis;
	}

	public Regostrovani addRegostrovani(Regostrovani regostrovani) {
		getRegostrovanis().add(regostrovani);
		regostrovani.setOcena(this);

		return regostrovani;
	}

	public Regostrovani removeRegostrovani(Regostrovani regostrovani) {
		getRegostrovanis().remove(regostrovani);
		regostrovani.setOcena(null);

		return regostrovani;
	}

}