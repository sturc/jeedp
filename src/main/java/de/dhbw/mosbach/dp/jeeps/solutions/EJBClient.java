package de.dhbw.mosbach.dp.jeeps.solutions;

import de.dhbw.mosbach.dp.jeeps.MitarbeiterDTO;
import de.dhbw.mosbach.dp.jeeps.MitarbeiterService;

public class EJBClient {

	public static void main(String[] args) {

		MitarbeiterService statelessEJB = new MitarbeiterServiceImpl();
		MitarbeiterDTO mitdto = statelessEJB.getMitarbeiterData(1001);
		printDto(mitdto);

		statelessEJB.setMitarbeiter(2000, "Vorname", "Nachname");
		mitdto = statelessEJB.getMitarbeiterData(2000);
		printDto(mitdto);

		statelessEJB.updateMitarbeiter(2000, "NewVorname", "NewNachname");
		mitdto = statelessEJB.getMitarbeiterData(2000);
		printDto(mitdto);

		statelessEJB.deleteMitarbeiter(mitdto.getPersnr());
		mitdto = statelessEJB.getMitarbeiterData(2000);
		printDto(mitdto);

	}

	private static void printDto(MitarbeiterDTO mitdto) {
		System.out.println(mitdto.getPersnr() + "," + mitdto.getVorname() + "," + mitdto.getNachname());
	}

}
