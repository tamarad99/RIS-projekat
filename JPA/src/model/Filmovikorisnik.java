package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


/**
 * The persistent class for the filmovikorisnik database table.
 * 
 */
@Entity
@Table(name="filmovikorisnik")
@NamedQuery(name="Filmovikorisnik.findAll", query="SELECT f FROM Filmovikorisnik f")
public class Filmovikorisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnik;

	@NotBlank(message="Unesite ime")
	private String ime;

	@NotBlank(message="Unesite korisnicko ime")
	private String korisnickoime;

	@NotBlank(message="Unesite prezime")
	private String prezime;

	@NotBlank(message="Unesite sifru")
	private String sifra;

	//bi-directional many-to-many association to Filmoviuloga
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="korisniks")
	private Set<Filmoviuloga> ulogas =new HashSet<>();

	public Filmovikorisnik() {
	}

	public int getIdkorisnik() {
		return this.idkorisnik;
	}

	public void setIdkorisnik(int idkorisnik) {
		this.idkorisnik = idkorisnik;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKorisnickoime() {
		return this.korisnickoime;
	}

	public void setKorisnickoime(String korisnickoime) {
		this.korisnickoime = korisnickoime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSifra() {
		return this.sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Set<Filmoviuloga> getUlogas() {
		return ulogas;
	}

	public void setUlogas(Set<Filmoviuloga> ulogas) {
		this.ulogas = ulogas;
	}


}