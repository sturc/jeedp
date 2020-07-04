package de.dhbw.mosbach.dp.jeeps.solutions;

import java.util.List;

import de.dhbw.mosbach.dp.jeeps.MitDAO;
import de.dhbw.mosbach.dp.jeeps.Mitarbeiter;

public class TestMitDao {

	public static void main(String[] args) {
		MitDAO mitDAO = new MitDAOImpl();
		Mitarbeiter m = mitDAO.getMitByPnr(1000);
		System.out.println(m);
		Mitarbeiter newMit = new Mitarbeiter(1003, "Heinz", "Becker");
		mitDAO.insertMit(newMit);
		List<Mitarbeiter> allMit = mitDAO.getAllMit();
		System.out.println("All Mitarbeiter:");
		for (Mitarbeiter currMit : allMit) {
			System.out.println(currMit);
		}
		mitDAO.deleteMit(1003);
		allMit = mitDAO.getAllMit();
		System.out.println("All Mitarbeiter:");
		for (Mitarbeiter currMit : allMit) {
			System.out.println(currMit);
		}
		List<Mitarbeiter> duffMit = mitDAO.findWithLastName("Duff");
		System.out.println("Duff Mitarbeiter:");
		for (Mitarbeiter currMit : duffMit) {
			System.out.println(currMit);
		}
	}

}
