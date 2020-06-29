package de.dhbw.mosbach.dp.jeeps.exercises;

import javax.ejb.Stateless;

import de.dhbw.mosbach.dp.jeeps.MitDAO;
import de.dhbw.mosbach.dp.jeeps.Mitarbeiter;
import de.dhbw.mosbach.dp.jeeps.MitarbeiterAssembler;
import de.dhbw.mosbach.dp.jeeps.MitarbeiterDTO;
import de.dhbw.mosbach.dp.jeeps.MitarbeiterService;

@Stateless
public class MitarbeiterServiceImpl implements MitarbeiterService {

	MitDAO dao = new MitDAOImpl();

	@Override
	public MitarbeiterDTO getMitarbeiterData(int persnr) {
		Mitarbeiter mit = dao.getMitByPnr(persnr);
		return new MitarbeiterAssembler().writeDTO(mit);
	}

	@Override
	public void setMitarbeiter(int persnr, String Vorname, String Nachname) {
		dao.insertMit(new Mitarbeiter(persnr, Vorname, Nachname));
	}

	@Override
	public void deleteMitarbeiter(int persnr) {
		dao.deleteMit(persnr);
	}

	@Override
	public void updateMitarbeiter(int persnr, String vorname, String nachname) {
		// TODO Implement

	}

}
