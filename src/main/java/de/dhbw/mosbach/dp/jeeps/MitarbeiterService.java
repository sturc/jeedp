package de.dhbw.mosbach.dp.jeeps;

import javax.ejb.Remote;

@Remote
public interface MitarbeiterService {
	public MitarbeiterDTO getMitarbeiterData(int persnr);

	public void setMitarbeiter(int persnr, String vorname, String nachname);

	public void deleteMitarbeiter(int persnr);

	public void updateMitarbeiter(int persnr, String vorname, String nachname);
}
