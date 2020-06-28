package de.dhbw.mosbach.dp.jeeps;

public class Mitarbeiter {
	private int persnr;
	private String nachname;
	private String vorname;

	public Mitarbeiter(int persnr, String vorname, String nachname) {
		this.persnr = persnr;
		this.nachname = nachname;
		this.vorname = vorname;
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

	public boolean checkSSNVadility() {
		// dummy Method
		return true;
	}

	public boolean checkHolidayBalance() {
		// dummy Method
		return true;
	}

}
