package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the filmoviuloga database table.
 * 
 */
@Entity
@Table(name="filmoviuloga")
@NamedQuery(name="Filmoviuloga.findAll", query="SELECT f FROM Filmoviuloga f")
public class Filmoviuloga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduloga;

	private String naziv;

	//bi-directional many-to-many association to Filmovikorisnik
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="filmovikorisnikuloga", joinColumns = @JoinColumn(name = "filmoviUloga_iduloga",referencedColumnName = "iduloga"),inverseJoinColumns = @JoinColumn(name = "filmoviKorisnik_idkorisnik"))
	private Set<Filmovikorisnik> korisniks =new HashSet<>();

	public Set<Filmovikorisnik> getKorisniks() {
		return korisniks;
	}

	public void setKorisniks(Set<Filmovikorisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public Filmoviuloga() {
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
	public void addKorisnik(Filmovikorisnik k) {
		this.korisniks.add(k);
	}

}