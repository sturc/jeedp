package de.dhbw.mosbach.dp.jeeps;

import javax.ejb.Stateless;

@Stateless
public class MitarbeiterServiceImpl implements MitarbeiterService {

	MitDAO dao = new MitDAOImpl();

	public MitarbeiterDTO getMitarbeiterData(int persnr) {
		Mitarbeiter mit = dao.getMitByPnr(persnr);
		return new MitarbeiterAssembler().writeDTO(mit);
	}

	public void setMitarbeiter(int persnr, String Vorname, String Nachname) {
		dao.insertMit(new Mitarbeiter(persnr, Vorname, Nachname));
	}

	public void deleteMitarbeiter(int persnr) {
		dao.deleteMit(persnr);
	}


}
