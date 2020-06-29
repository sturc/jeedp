package de.dhbw.mosbach.dp.jeeps.exercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import de.dhbw.mosbach.dp.jeeps.MitDAO;
import de.dhbw.mosbach.dp.jeeps.Mitarbeiter;

public class MitDAOImpl implements MitDAO {

	private Connection con = null;
	private PreparedStatement selectAll;
	private PreparedStatement selectByPersNr;
	private PreparedStatement insertNewMitarbeiter;
	private PreparedStatement deleteMitarbeiter;

	private static String url = "jdbc:mysql://localhost:3306/mysqldp";
	private static String user = "mysql";
	private static String pwd = "mysql";


	public MitDAOImpl() {
		initDAO();
	}

	private void initDAO() {

		try {
			con = DriverManager.getConnection(url, user, pwd);
			con.setAutoCommit(false);
			selectAll = con.prepareStatement("SELECT * FROM Mitarbeiter");
			selectByPersNr = con.prepareStatement("SELECT * FROM Mitarbeiter WHERE PERSNR= ?");
			insertNewMitarbeiter = con.prepareStatement("INSERT INTO Mitarbeiter values ( ?, ?, ?)");
			deleteMitarbeiter = con.prepareStatement("DELETE FROM Mitarbeiter WHERE PERSNR= ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Mitarbeiter> getAllMit() {
		List<Mitarbeiter> list = new LinkedList<Mitarbeiter>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while (rs.next()) {
				Mitarbeiter m = createMitarbeiterFromCurrRow(rs);
				list.add(m);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private Mitarbeiter createMitarbeiterFromCurrRow(ResultSet rs) throws SQLException {
		int persnr = rs.getInt("PERSNR");
		String nachname = rs.getString("NACHNAME");
		String vorname = rs.getString("VORNAME");
		Mitarbeiter m = new Mitarbeiter(persnr, vorname, nachname);
		return m;
	}


	public Mitarbeiter getMitByPnr(int persnr) {
		try {
			selectByPersNr.setInt(1, persnr);
			ResultSet rs = selectByPersNr.executeQuery();
			if (rs.next()) {
				return createMitarbeiterFromCurrRow(rs);
			}
			con.commit();
		} catch (SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
		return null;
	}


	public void insertMit(Mitarbeiter m) {
		try {
			insertNewMitarbeiter.setInt(1, m.getPersnr());
			insertNewMitarbeiter.setString(2, m.getNachname());
			insertNewMitarbeiter.setString(3, m.getVorname());
			insertNewMitarbeiter.executeUpdate();
			con.commit();
		} catch (SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
	}

	public void deleteMit(int persnr) {
		try {
			deleteMitarbeiter.setInt(1, persnr);
			deleteMitarbeiter.execute();
			con.commit();
		} catch (SQLException e1) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
	}

	public List<Mitarbeiter> findWithLastName(String lastName) {
		// TODO add implementation
		return null;
	}

}
