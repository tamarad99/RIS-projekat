package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the glumac database table.
 * 
 */
@Entity
@Table(name="glumac")
@NamedQuery(name="Glumac.findAll", query="SELECT g FROM Glumac g")
public class Glumac implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idglumac;

	private String ime;

	private String prezime;
	
	private int godina;
	
	

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	@Lob
	private byte[] slika;

	//bi-directional many-to-one association to Uloga
	@OneToMany(mappedBy="glumac")
	private List<Uloga> ulogas;

	public Glumac() {
	}

	public int getIdglumac() {
		return this.idglumac;
	}

	public void setIdglumac(int idglumac) {
		this.idglumac = idglumac;
	}
	
	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public byte[] getSlika() {
		return this.slika;
	}

	public void setSlika(byte[] slika) {
		this.slika = slika;
	}

	public List<Uloga> getUlogas() {
		return this.ulogas;
	}

	public void setUlogas(List<Uloga> ulogas) {
		this.ulogas = ulogas;
	}

	public Uloga addUloga(Uloga uloga) {
		getUlogas().add(uloga);
		uloga.setGlumac(this);

		return uloga;
	}

	public Uloga removeUloga(Uloga uloga) {
		getUlogas().remove(uloga);
		uloga.setGlumac(null);

		return uloga;
	}

}