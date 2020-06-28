package de.dhbw.mosbach.dp.jeeps;

import java.util.List;

public interface MitDAO {

	public Mitarbeiter getMitByPnr(int persnr);

	public List<Mitarbeiter> getAllMit();

	public void insertMit(Mitarbeiter m);

	public void deleteMit(int persnr);

	public List<Mitarbeiter> findWithLastName(String lastName);

}
