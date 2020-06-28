package de.dhbw.mosbach.dp.jeeps;

import javax.ejb.Remote;

@Remote
public interface MitarbeiterService {
	public MitarbeiterDTO getMitarbeiterData(int persnr);

	public void setMitarbeiter(int persnr, String Vorname, String Nachname);

	public void deleteMitarbeiter(int persnr);
}
