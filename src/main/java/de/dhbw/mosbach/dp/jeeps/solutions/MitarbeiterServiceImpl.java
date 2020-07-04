package de.dhbw.mosbach.dp.jeeps.solutions;

import javax.ejb.Stateless;

import de.dhbw.mosbach.dp.jeeps.MitDAO;
import de.dhbw.mosbach.dp.jeeps.Mitarbeiter;
import de.dhbw.mosbach.dp.jeeps.MitarbeiterAssembler;
import de.dhbw.mosbach.dp.jeeps.MitarbeiterDTO;
import de.dhbw.mosbach.dp.jeeps.MitarbeiterService;

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

	@Override
	public void updateMitarbeiter(int persnr, String vorname, String nachname) {
		deleteMitarbeiter(persnr);
		setMitarbeiter(persnr, vorname, nachname);
	}

}
