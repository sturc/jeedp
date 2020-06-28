package de.dhbw.mosbach.dp.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mitarbeiter")
public class Mitarbeiter implements Serializable {

	private static final long serialVersionUID = 1L;

	// default Constructor
	public Mitarbeiter() {
	}

	public Mitarbeiter(int persnr, String nachname, String vorname) {
		this.persnr = persnr;
		this.nachname = nachname;
		this.vorname = vorname;
	}

	@Id
	@Column(name = "persnr")
	int persnr;

	@Column(name = "nachname")
	String nachname;

	@Column(name = "vorname")
	String vorname;

	public void setPersnr(int persnr) {
		this.persnr = persnr;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getPersnr() {
		return persnr;
	}

	public String toString() {
		return persnr + ": " + nachname + ", " + vorname;
	}

}
