package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the regostrovani database table.
 * 
 */
@Entity
@NamedQuery(name="Regostrovani.findAll", query="SELECT r FROM Regostrovani r")
public class Regostrovani implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idkorisnik;

	private String adresa;

	private int idregistrovani;

	private String korisnickoime;

	//bi-directional many-to-one association to Ocena
	@ManyToOne
	private Ocena ocena;

	public Regostrovani() {
	}

	public int getIdkorisnik() {
		return this.idkorisnik;
	}

	public void setIdkorisnik(int idkorisnik) {
		this.idkorisnik = idkorisnik;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public int getIdregistrovani() {
		return this.idregistrovani;
	}

	public void setIdregistrovani(int idregistrovani) {
		this.idregistrovani = idregistrovani;
	}

	public String getKorisnickoime() {
		return this.korisnickoime;
	}

	public void setKorisnickoime(String korisnickoime) {
		this.korisnickoime = korisnickoime;
	}

	public Ocena getOcena() {
		return this.ocena;
	}

	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}

}