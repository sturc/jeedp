package de.dhbw.mosbach.dp.jeeps;

import java.util.List;

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
	}

}
